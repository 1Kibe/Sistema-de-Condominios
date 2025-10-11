package com.ryan.condominosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryan.condominosys.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
