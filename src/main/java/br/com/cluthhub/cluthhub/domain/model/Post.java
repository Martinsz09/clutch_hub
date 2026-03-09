package br.com.cluthhub.cluthhub.domain.model;

import java.util.List;
import java.util.UUID;

import br.com.cluthhub.cluthhub.domain.enums.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Lob
    private String content;


    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Vote> voteList;

    @Column(name = "total_votes")
    private Integer votes = 0;

    public Integer getTotalVotes() {
        return this.votes != null ? this.votes : 0;
    }

}
