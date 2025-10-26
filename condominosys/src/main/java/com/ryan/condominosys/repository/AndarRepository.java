package com.ryan.condominosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryan.condominosys.domain.Andar;
import com.ryan.condominosys.repository.query.AndarRepositoryQuery;

public interface AndarRepository extends JpaRepository<Andar, Long>, AndarRepositoryQuery {

}
