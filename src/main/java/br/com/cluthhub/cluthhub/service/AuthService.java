package br.com.cluthhub.cluthhub.service;

import br.com.cluthhub.cluthhub.domain.dto.AuthDto;
import br.com.cluthhub.cluthhub.domain.model.Authority;
import br.com.cluthhub.cluthhub.domain.model.User;
import br.com.cluthhub.cluthhub.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public User register(AuthDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);

        Authority role = new Authority();
        role.setAuthority("ROLE_USER");
        role.setUsername(dto.getUsername());
        user.setAuthorities(Collections.singletonList(role));

        return repo.save(user);
    }
}