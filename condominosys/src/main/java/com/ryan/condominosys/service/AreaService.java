package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Area;
import com.ryan.condominosys.repository.AreaRepository;

@Service
public class AreaService {
    @Autowired
    private final AreaRepository repository;

    public AreaService(AreaRepository areaRepository) {
        this.repository = areaRepository;
    }

    public List<Area> listarTodos() {
        return repository.findAll();
    }

    public Optional<Area> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Area salvar(Area area) {
        return repository.save(area);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
