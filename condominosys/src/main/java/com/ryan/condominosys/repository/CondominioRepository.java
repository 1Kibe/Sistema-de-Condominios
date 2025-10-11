package com.ryan.condominosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryan.condominosys.domain.Condominio;

public interface CondominioRepository extends JpaRepository<Condominio, Long>  {
    
}
