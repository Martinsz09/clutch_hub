package br.com.cluthhub.cluthhub.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cluthhub.cluthhub.domain.model.Post;
import br.com.cluthhub.cluthhub.domain.model.User;
import br.com.cluthhub.cluthhub.domain.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, UUID>{
    Optional<Vote> findByUserAndPost(User user, Post post);

    @Query("SELECT SUM(v.value) FROM Vote v WHERE v.post.id = :postId")
    Integer sumVotesByPostId(UUID postId);
}
