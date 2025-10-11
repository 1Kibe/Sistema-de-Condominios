package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Regras;
import com.ryan.condominosys.repository.RegrasRepository;

@Service
public class RegrasService {
    private final RegrasRepository repository;

    public RegrasService(RegrasRepository regrasRepository) {
        this.repository = regrasRepository;
    }

    public List<Regras> listarTodos() {
        return repository.findAll();
    }

    public Optional<Regras> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Regras salvar(Regras regras) {
        return repository.save(regras);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
