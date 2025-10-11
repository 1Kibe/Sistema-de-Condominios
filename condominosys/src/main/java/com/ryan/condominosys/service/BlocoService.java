package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Bloco;
import com.ryan.condominosys.repository.BlocoRepository;

@Service
public class BlocoService {
    @Autowired
    private final BlocoRepository repository;

    public BlocoService(BlocoRepository blocoRepository) {
        this.repository = blocoRepository;
    }

    public List<Bloco> listarTodos() {
        return repository.findAll();
    }

    public Optional<Bloco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Bloco salvar(Bloco bloco) {
        return repository.save(bloco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
