package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Endereco;
import com.ryan.condominosys.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.repository = enderecoRepository;
    }

    public List<Endereco> listarTodos() {
        return repository.findAll();
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
