package com.ryan.condominosys.domain.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ryan.condominosys.domain.Users;
import com.ryan.condominosys.domain.dto.input.usuario.UsersInputDto;
import com.ryan.condominosys.domain.dto.output.usuario.UsersDto;

@Component
public class UsuarioMapper {

    @Autowired
    private ModelMapper mapper;

    // ===============================================================================================

    // Classe para DTO

    public UsersDto converterParaDto(Users entity) {
        return mapper.map(entity, UsersDto.class);
    }

    public List<UsersDto> converterListaParaDto(List<Users> entitys) {
        return entitys.stream()
                .map(entiT -> converterParaDto(entiT))
                .collect(Collectors.toList());
    }

    // ===============================================================================================

    // DTOInput para Classe

    public Users converterParaClasse(UsersInputDto entity) {
        return mapper.map(entity, Users.class);
    }

    public List<Users> converterListaParaClasse(List<UsersInputDto> entitys) {
        return entitys.stream()
                .map(entiT -> converterParaClasse(entiT))
                .collect(Collectors.toList());
    }
    
    // ===============================================================================================

}
