package com.ryan.condominosys.domain.dto.input.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersInputDto {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotNull
    @Email
    private String email;

}
