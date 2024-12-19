package com.ActivateGym.Api.admin.auth.presentation;

import com.ActivateGym.Api.admin.auth.domain.dto.CreateUserDto;
import com.ActivateGym.Api.admin.auth.domain.entity.ERole;
import com.ActivateGym.Api.admin.auth.domain.entity.RoleEntity;
import com.ActivateGym.Api.admin.auth.domain.entity.UserEntity;
import com.ActivateGym.Api.admin.auth.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/createuser")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDto createUserDto){

        Set<RoleEntity> roles = createUserDto.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .nombreRol(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());

        UserEntity userEntity = UserEntity.builder()
                .username(createUserDto.getUsername())
                .password(passwordEncoder.encode(createUserDto.getPassword()))
                .roles(roles)
                .build();
        userRepository.save(userEntity);
        return  ResponseEntity.ok(userEntity);
    }

    @DeleteMapping("/deleteUser")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public String deleteUser(@RequestParam String id){
        userRepository.deleteById(Long.parseLong(id));
        return "se ha borrado el user :".concat(id);
    }
}
