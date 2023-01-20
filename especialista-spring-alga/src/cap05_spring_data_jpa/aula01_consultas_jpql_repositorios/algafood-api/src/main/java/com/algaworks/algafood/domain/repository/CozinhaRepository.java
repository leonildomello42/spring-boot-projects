package com.algaworks.algafood.domain.repository;


import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha salvar(Cozinha cozinha);
    Cozinha buscar(Long id);
    void remover(Long id);
    List<Cozinha> consultarPorNome(String nome);
}
