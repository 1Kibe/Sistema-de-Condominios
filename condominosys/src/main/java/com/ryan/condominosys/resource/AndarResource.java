package com.ryan.condominosys.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryan.condominosys.domain.Andar;
import com.ryan.condominosys.repository.filter.AndarRepositoryFilter;
import com.ryan.condominosys.service.AndarService;

@RestController
@RequestMapping(value = "/andar")
public class AndarResource {
    @Autowired
    private final AndarService service;

    public AndarResource(AndarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Andar>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Andar> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pg")
    public List<Andar> pg(AndarRepositoryFilter filtro) {
        return service.pg(filtro);
    }

    @PostMapping
    public ResponseEntity<Andar> salvar(@RequestBody Andar obj) {
        Andar novo = service.salvar(obj);
        return ResponseEntity.ok(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Andar> atualizar(@PathVariable Long id, @RequestBody Andar obj) {
        return service.buscarPorId(id)
                .map(existente -> {
                    obj.setId(id);
                    Andar atualizado = service.salvar(obj);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
