package com.ryan.condominosys.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permisions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToMany
    @JoinTable(
        name = "user_permisions",                               // Nome da nova tabela de junção
        joinColumns = @JoinColumn(name = "permisions_id"),      // Coluna que referencia Permisions
        inverseJoinColumns = @JoinColumn(name = "user_id")      // Coluna da FK que aponta PARA A OUTRA CLASSE (User)
    )
    private List<Users> users;
}
