package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping(value = "/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {

        Cozinha cozinha =  cozinhaRepository.buscar(cozinhaId);

        if (cozinha != null) {
            return ResponseEntity.ok(cozinha);
        }
//         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
       return cadastroCozinhaService.salvar(cozinha);
    }


    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
                                             @RequestBody Cozinha cozinha) {

        Cozinha cozinhaAtual = cozinhaRepository.buscar(cozinhaId);

        if (cozinhaAtual != null) {

            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

            cozinhaAtual = cadastroCozinhaService.salvar(cozinhaAtual);
            return ResponseEntity.ok(cozinhaAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
        try {
            cadastroCozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}