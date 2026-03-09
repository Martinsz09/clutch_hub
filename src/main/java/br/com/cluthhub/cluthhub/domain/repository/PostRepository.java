package br.com.cluthhub.cluthhub.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cluthhub.cluthhub.domain.model.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {
    
    
}
