package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Reserva;
import com.ryan.condominosys.repository.ReservaRepository;

@Service
public class ReservaService {
    @Autowired
    private final ReservaRepository repository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.repository = reservaRepository;
    }

    public List<Reserva> listarTodos() {
        return repository.findAll();
    }

    public Optional<Reserva> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Reserva salvar(Reserva reserva) {
        return repository.save(reserva);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
