package br.com.cluthhub.cluthhub.service;

import java.util.UUID;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.cluthhub.cluthhub.domain.model.Post;
import br.com.cluthhub.cluthhub.domain.model.User;
import br.com.cluthhub.cluthhub.domain.model.Vote;
import br.com.cluthhub.cluthhub.domain.repository.PostRepository;
import br.com.cluthhub.cluthhub.domain.repository.UserRepository;
import br.com.cluthhub.cluthhub.domain.repository.VoteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepo;
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Transactional
    public void vote(UUID postId, Integer value) {
        if (value != 1 && value != -1) throw new IllegalArgumentException("Voto deve ser 1 ou -1");

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByUsername(username)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Post post = postRepo.findById(postId)
                            .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        voteRepo.findByUserAndPost(user, post).ifPresentOrElse(
            vote -> {
                if (vote.getValue().equals(value)) {
                    voteRepo.delete(vote); 
                } else {
                    vote.setValue(value);
                    voteRepo.save(vote);
                }
            },
            () -> {
                Vote newVote = new Vote();
                newVote.setUser(user);
                newVote.setPost(post);
                newVote.setValue(value);
                voteRepo.save(newVote);
            }
        );

        Integer total = voteRepo.sumVotesByPostId(postId);
        post.setVotes(total != null ? total : 0);
        postRepo.save(post);
    }
}