package com.ryan.condominosys.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryan.condominosys.domain.Users;
import com.ryan.condominosys.exception.enitities.Usuario.UsuarioNaoEncontradoException;
import com.ryan.condominosys.exception.generic.NegocioException;
import com.ryan.condominosys.repository.UsersRepository;

import jakarta.transaction.Transactional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository repository;

    public UsersService(UsersRepository usersRepository) {
        this.repository = usersRepository;
    }

    @Transactional
    public List<Users> listarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Users buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }

    @Transactional
    public Users salvar(Users users) {
        // 1. Encontra se já existe um usuário com o mesmo e-mail
        Optional<Users> usuarioExistente = repository.findByEmail(users.getEmail());

        // 2. Verifica se o usuário existe E se o ID é DIFERENTE do usuário que estamos
        if (usuarioExistente.isPresent()) {
            Long idExistente = usuarioExistente.get().getId();

            // Se users.getId() for nulo OU se os IDs forem diferentes, há um conflito de
            // e-mail.
            if (users.getId() == null || !idExistente.equals(users.getId())) {
                throw new NegocioException(
                        String.format("Já existe um usuário cadastrado com o email %s", users.getEmail()));
            }
        }

        // O detach() não é necessário aqui, pois o Spring/JPA cuida do ciclo de vida.
        // Se o ID for null (POST), ele cria; se tiver ID (PUT), ele atualiza.
        return repository.save(users);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
