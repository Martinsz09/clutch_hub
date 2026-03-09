package br.com.cluthhub.cluthhub.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import br.com.cluthhub.cluthhub.domain.dto.PostDto;
import br.com.cluthhub.cluthhub.domain.model.Post;
import br.com.cluthhub.cluthhub.domain.model.User;
import br.com.cluthhub.cluthhub.domain.repository.PostRepository;
import br.com.cluthhub.cluthhub.domain.repository.UserRepository; 
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repo;
    private final UserRepository userRepo; 

    public Post save(PostDto dto) {
        if(dto == null) throw new IllegalArgumentException("PostDto cannot be null.");

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        
        User user = userRepo.findByUsername(username)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCategory(dto.getCategory());
        post.setVotes(dto.getVotes() != null ? dto.getVotes() : 0);
        
        post.setAuthor(user); 
        
        return repo.save(post);
    }
}