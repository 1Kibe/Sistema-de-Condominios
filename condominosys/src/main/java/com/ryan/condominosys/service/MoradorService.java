package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Morador;
import com.ryan.condominosys.repository.MoradorRepository;

@Service
public class MoradorService {
    @Autowired
    private final MoradorRepository repository;
    
    public MoradorService(MoradorRepository moradorRepository) {
        this.repository = moradorRepository;
    }

    public List<Morador> listarTodos() {
        return repository.findAll();
    }

    public Optional<Morador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Morador salvar(Morador morador) {
        return repository.save(morador);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
