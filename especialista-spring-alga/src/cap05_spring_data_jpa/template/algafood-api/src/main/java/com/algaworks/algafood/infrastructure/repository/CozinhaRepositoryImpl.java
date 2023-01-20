package com.algaworks.algafood.infrastructure.repository;


import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Cozinha> listar() {

        TypedQuery<Cozinha> query = entityManager.createQuery("FROM Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha) {
        return  entityManager.merge(cozinha);
    }

    @Override
    public Cozinha buscar(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public void remover(Long id) {
        Cozinha cozinha = buscar(id);

        if (cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }

        entityManager.remove(cozinha);
    }

//    @Override
//    public List<Cozinha> consultarPorNome(String nome) {
//        return entityManager.createQuery("FROM Cozinha  WHERE nome = :nome", Cozinha.class)
//                .setParameter("nome", nome)
//                .getResultList();
//    }

    @Override
    public List<Cozinha> consultarPorNome(String nome) {
        return entityManager.createQuery("FROM Cozinha  WHERE nome LIKE :nome", Cozinha.class)
                .setParameter("nome","%" + nome + "%")
                .getResultList();
    }
}
