package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Visitante;
import com.ryan.condominosys.repository.VisitanteRepository;

@Service
public class VisitanteService {
    @Autowired
    public final VisitanteRepository repository;

    public VisitanteService(VisitanteRepository visitanteRepository) {
        this.repository = visitanteRepository;
    }

    public List<Visitante> listarTodos() {
        return repository.findAll();
    }

    public Optional<Visitante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Visitante salvar(Visitante visitate) {
        return repository.save(visitate);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
