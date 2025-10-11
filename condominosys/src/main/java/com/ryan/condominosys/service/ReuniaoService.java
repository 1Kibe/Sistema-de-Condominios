package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Reuniao;
import com.ryan.condominosys.repository.ReuniaoRepository;

@Service
public class ReuniaoService {
    @Autowired
    private final ReuniaoRepository repository;

    public ReuniaoService(ReuniaoRepository reuniaoRepository) {
        this.repository = reuniaoRepository;
    }

    public List<Reuniao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Reuniao> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Reuniao salvar(Reuniao reuniao) {
        return repository.save(reuniao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
