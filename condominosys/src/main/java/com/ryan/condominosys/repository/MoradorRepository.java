package com.ryan.condominosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryan.condominosys.domain.Morador;

public interface MoradorRepository extends JpaRepository<Morador, Long> {

}
