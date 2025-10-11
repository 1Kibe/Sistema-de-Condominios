package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Residencia;
import com.ryan.condominosys.repository.ResidenciaRepository;

@Service
public class ResidenciaService {
    @Autowired
    private final ResidenciaRepository repository;

    public ResidenciaService(ResidenciaRepository residenciaRepository) {
        this.repository = residenciaRepository;
    }

    public List<Residencia> listarTodos() {
        return repository.findAll();
    }

    public Optional<Residencia> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Residencia salvar(Residencia residencia) {
        return repository.save(residencia);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
