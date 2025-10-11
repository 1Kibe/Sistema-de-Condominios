package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Permisions;
import com.ryan.condominosys.repository.PermisionsRepository;

@Service
public class PermisionsService {
    @Autowired
    private final PermisionsRepository repository;

    public PermisionsService(PermisionsRepository permisionsRepository) {
        this.repository = permisionsRepository;
    }

    public List<Permisions> listarTodos() {
        return repository.findAll();
    }

    public Optional<Permisions> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Permisions salvar(Permisions permisions) {
        return repository.save(permisions);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
