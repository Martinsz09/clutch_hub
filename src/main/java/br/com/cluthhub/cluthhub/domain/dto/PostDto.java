package br.com.cluthhub.cluthhub.domain.dto;



import br.com.cluthhub.cluthhub.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class PostDto {
    
    private String title;

    private Category category;

    private String content;

    private Integer votes;
}
