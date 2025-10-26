package com.ryan.condominosys.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.ryan.condominosys.domain.Andar;
import com.ryan.condominosys.repository.filter.AndarRepositoryFilter;

import jakarta.persistence.criteria.Predicate;

import org.springframework.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class AndarRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

    public List<Andar> pg (AndarRepositoryFilter filter) {

        CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
        CriteriaQuery<Andar> criteriaQuery = criteriaBuilder.createQuery(Andar.class);
        Root<Andar> root = criteriaQuery.from(Andar.class);

        List<Predicate> predicates = new ArrayList<>();

        if(filter.getId() != null){
            predicates.add(criteriaBuilder.equal(root.get("id"),filter.getId()));
        }

        if(filter.getAndarQuantidadeResidencias() != null){
            predicates.add(criteriaBuilder.equal(root.get("andarQuantidadeDeResidencias"), filter.getAndarQuantidadeResidencias()));
        }

        if(StringUtils.hasLength(filter.getNome())){
            predicates.add(criteriaBuilder.like(root.get("nome"), "%" + filter.getNome() + "%"));
        }

        if(StringUtils.hasLength(filter.getBloco())){
            predicates.add(criteriaBuilder.like(root.get("bloco").get("nome"), "%" + filter.getBloco() + "%"));
        }

        //salva os predicates
        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Andar> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }

}
