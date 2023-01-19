package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante salvar(Restaurante restaurante);
    Restaurante buscar(Long id);
    void remover(Restaurante restaurante);
}
