package com.ryan.condominosys.exception.enitities.Usuario;

import com.ryan.condominosys.exception.generic.EntidadeNaoEncontradaException;

public class UsuarioNaoEncontradoException extends EntidadeNaoEncontradaException {
    public UsuarioNaoEncontradoException(String message) {
        super(message);
    }

    public UsuarioNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsuarioNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de usuario com código %d", id));
    }
}
