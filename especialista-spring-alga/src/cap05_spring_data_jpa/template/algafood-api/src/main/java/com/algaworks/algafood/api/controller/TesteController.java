package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    CozinhaRepository cozinhaRepository;

//    @GetMapping("/cozinhas/por-nome/{nome}")
//    public List<Cozinha> cozinhaPorNome(@PathVariable  String nome){
//        return cozinhaRepository.consultarPorNome(nome);
//    }

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome){
        return cozinhaRepository.consultarPorNome(nome);
    }

}
