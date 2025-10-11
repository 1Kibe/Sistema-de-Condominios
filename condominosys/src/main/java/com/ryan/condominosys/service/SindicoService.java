package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Sindico;
import com.ryan.condominosys.repository.SindicoRepository;

@Service
public class SindicoService {
    @Autowired
    public final SindicoRepository repository;

    public SindicoService(SindicoRepository sindicoRepository) {
        this.repository = sindicoRepository;
    }

    public List<Sindico> listarTodos() {
        return repository.findAll();
    }
    
    public Optional<Sindico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Sindico salvar(Sindico sindico) {
        return repository.save(sindico);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
