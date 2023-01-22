package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    CozinhaRepository cozinhaRepository;

    @Autowired
    RestauranteRepository restauranteRepository;


//    @GetMapping("/cozinhas/por-nome/{nome}")
//    public List<Cozinha> cozinhaPorNome(@PathVariable  String nome){
//        return cozinhaRepository.nome(nome);
//    }

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome){
        return cozinhaRepository.findTodasByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public Optional<Cozinha> cozinhaPorNomeUnico(@RequestParam String nome) {
        return cozinhaRepository.findUnicaByNome(nome);
    }

    @GetMapping("/cozinhas/exists")
    public boolean cozinhaExists(String nome) {
        return cozinhaRepository.existsByNome(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(
            @RequestParam BigDecimal taxaInicial, @RequestParam BigDecimal taxaFinal) {
        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }


//    @GetMapping("/restaurantes/por-nome")
//    public List<Restaurante> restaurantesPorTaxaFrete(
//            String nome, Long cozinhaId) {
//        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
//    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(
            String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNomeXML(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantePrimeiroPorNome(String nome) {
        return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/count-por-cozinha")
    public int restaurantesCountPorCozinha(Long cozinhaId) {
        return restauranteRepository.countByCozinhaId(cozinhaId);
    }

}
