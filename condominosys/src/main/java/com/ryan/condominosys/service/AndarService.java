package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Andar;
import com.ryan.condominosys.repository.AndarRepository;

@Service
public class AndarService {
    @Autowired
    private final AndarRepository repository;

    public AndarService(AndarRepository andarRepository) {
        this.repository = andarRepository;
    }

    public List<Andar> listarTodos() {
        return repository.findAll();
    }

    public Optional<Andar> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Andar salvar(Andar andar) {
        return repository.save(andar);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
