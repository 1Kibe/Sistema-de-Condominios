package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Funcionario;
import com.ryan.condominosys.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.repository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Funcionario salvar(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
