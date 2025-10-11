package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Condominio;
import com.ryan.condominosys.repository.CondominioRepository;

@Service
public class CondominioService {
    @Autowired
    private final CondominioRepository repository;

    public CondominioService(CondominioRepository condominioRepository) {
        this.repository = condominioRepository;
    }

    public List<Condominio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Condominio> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Condominio salvar(Condominio condominio) {
        return repository.save(condominio);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
