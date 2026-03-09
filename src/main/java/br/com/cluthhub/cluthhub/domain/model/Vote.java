package br.com.cluthhub.cluthhub.domain.model;

import jakarta.persistence.*;
import lombok.Data; 
import java.util.UUID;

@Entity
@Data 
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    
    private Integer value;
}