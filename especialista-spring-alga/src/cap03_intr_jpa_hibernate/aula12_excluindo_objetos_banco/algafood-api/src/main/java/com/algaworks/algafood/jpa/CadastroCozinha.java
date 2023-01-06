package com.algaworks.algafood.jpa;


import com.algaworks.algafood.domain.model.Cozinha;

import java.util.List;

public interface CadastroCozinha {

    List<Cozinha> listar();

    Cozinha salvar(Cozinha cozinha);

    Cozinha buscar(Long id);

    void remover(Cozinha cozinha);
}
