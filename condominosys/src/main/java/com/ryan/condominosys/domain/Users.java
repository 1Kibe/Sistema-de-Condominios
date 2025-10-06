package com.ryan.condominosys.domain;

import java.time.OffsetDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String passwordHash;
    private Boolean isActive;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastAccess;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Permisions> permisions;
}
