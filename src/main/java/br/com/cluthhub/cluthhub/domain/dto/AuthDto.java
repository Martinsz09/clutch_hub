package br.com.cluthhub.cluthhub.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AuthDto {

    private String username;

    private String email;

    private String password;
}
