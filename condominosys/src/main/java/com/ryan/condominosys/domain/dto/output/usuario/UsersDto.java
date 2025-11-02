package com.ryan.condominosys.domain.dto.output.usuario;

import java.time.OffsetDateTime;
import java.util.List;

import com.ryan.condominosys.domain.dto.output.permisions.PermisionsDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
    private Long id;
    private String username;
    //  private String password; //se colocar passwordHash atualmene retorna null   
    private String email;
    private Boolean isActive;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastAccess;
    private List<PermisionsDto> permisions;
}
