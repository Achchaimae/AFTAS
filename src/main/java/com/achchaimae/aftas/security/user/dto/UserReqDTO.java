package com.achchaimae.aftas.security.user.dto;

import com.achchaimae.aftas.security.user.enumeration.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class UserReqDTO {
    private UUID id;
    @NotBlank(message = "first name cannot be blank")
    @Size(max = 255, message = "first name must not exceed 255 characters")
    private String firstname;

    @NotBlank(message = "last name cannot be blank")
    @Size(max = 255, message = "last name must not exceed 255 characters")
    private String lastname;

    @NotBlank(message = "email cannot be blank")
    @Size(max = 1000, message = "Email must not exceed 1000 characters")
    private String email;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 8, message = "Password must exceed 8  characters")
    private String password;

    private Role role;
}
