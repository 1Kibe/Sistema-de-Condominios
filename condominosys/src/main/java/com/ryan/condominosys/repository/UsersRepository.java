package com.ryan.condominosys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryan.condominosys.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}
