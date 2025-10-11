package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Users;
import com.ryan.condominosys.repository.UsersRepository;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository repository;

    public UsersService(UsersRepository usersRepository) {
        this.repository = usersRepository;
    }

    public List<Users> listarTodos() {
        return repository.findAll();
    }
    
    public Optional<Users> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Users salvar(Users users) {
        return repository.save(users);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
