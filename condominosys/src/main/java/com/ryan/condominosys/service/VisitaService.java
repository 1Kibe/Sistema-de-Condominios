package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Visita;
import com.ryan.condominosys.repository.VisitaRepository;

@Service
public class VisitaService {
    @Autowired
    public final VisitaRepository repository;

    public VisitaService(VisitaRepository visitaRepository) {
        this.repository = visitaRepository;
    }

    public List<Visita> listarTodos() {
        return repository.findAll();
    }

    public Optional<Visita> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Visita salvar(Visita visita) {
        return repository.save(visita);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    
}   
