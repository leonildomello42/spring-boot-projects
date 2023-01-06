package com.algaworks.algafood.jpa.impl;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.jpa.CadastroCozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinhaImpl implements CadastroCozinha {

    @PersistenceContext
    EntityManager entityManager;

    public CadastroCozinhaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Cozinha> listar() {
//        TypedQuery<Cozinha> query2 = entityManager.createQuery("SELECT nome FROM Cozinha", Cozinha.class);

        TypedQuery<Cozinha> query = entityManager.createQuery("FROM Cozinha", Cozinha.class);
        return query.getResultList();
    }
}
