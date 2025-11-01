package com.ryan.condominosys.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.condominosys.domain.Users;
import com.ryan.condominosys.service.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersResource {
    @Autowired
    private final UsersService service;

    public UsersResource(UsersService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Users>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public Users buscarPorId(@PathVariable Long id) {
            return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<Users> salvar(@RequestBody Users obj) {
        Users novo = service.salvar(obj);
        return ResponseEntity.ok(novo);
    }

    // @PutMapping("/{id}")
    // public ResponseEntity<Users> atualizar(@PathVariable Long id, @RequestBody Users obj) {
    //     return service.buscarPorId(id)
    //             .map(existente -> {
    //                 obj.setId(id);
    //                 Users atualizado = service.salvar(obj);
    //                 return ResponseEntity.ok(atualizado);
    //             })
    //             .orElse(ResponseEntity.notFound().build());
    // }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deletar(@PathVariable Long id) {
    //     if (service.buscarPorId(id).isPresent()) {
    //         service.deletar(id);
    //         return ResponseEntity.noContent().build();
    //     }
    //     return ResponseEntity.notFound().build();
    // }
}
