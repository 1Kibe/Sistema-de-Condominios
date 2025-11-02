package com.ryan.condominosys.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.condominosys.domain.Users;
import com.ryan.condominosys.domain.dto.input.usuario.UsersInputDto;
import com.ryan.condominosys.domain.dto.mapper.UsuarioMapper;
import com.ryan.condominosys.domain.dto.output.usuario.UsersDto;
import com.ryan.condominosys.service.UsersService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {

    @Autowired
    private final UsersService service;

    // ===

    @Autowired
    private UsuarioMapper mapper;

    // ===

    public UsersResource(UsersService service) {
        this.service = service;
    }

    @Transactional
    @GetMapping
    public List<UsersDto> listarTodos() {
        return mapper.converterListaParaDto(service.listarTodos());
    }

    @GetMapping("/{id}")
    public UsersDto buscarPorId(@PathVariable Long id) {
        return mapper.converterParaDto(service.buscarPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public UsersDto salvar(@Valid @RequestBody UsersInputDto body) {
        Users entityClass = mapper.converterParaClasse(body);
        return mapper.converterParaDto(service.salvar(entityClass));
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Users> atualizar(@PathVariable Long id, @RequestBody
    // Users obj) {
    // return service.buscarPorId(id)
    // .map(existente -> {
    // obj.setId(id);
    // Users atualizado = service.salvar(obj);
    // return ResponseEntity.ok(atualizado);
    // })
    // .orElse(ResponseEntity.notFound().build());
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deletar(@PathVariable Long id) {
    // if (service.buscarPorId(id).isPresent()) {
    // service.deletar(id);
    // return ResponseEntity.noContent().build();
    // }
    // return ResponseEntity.notFound().build();
    // }
}
