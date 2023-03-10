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
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

//@Controller
//@ResponseBody

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar(){
        return cozinhaRepository.findAll();
    }

    @GetMapping(value = "/{cozinhaId}")
    public Cozinha buscar(@PathVariable Long cozinhaId) {
        return cadastroCozinha.buscarOuFalhar(cozinhaId);
    }

//    @GetMapping(value = "/{cozinhaId}")
//    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
//
//        Optional<Cozinha> cozinha =  cozinhaRepository.findById(cozinhaId);
//
//
////        return cozinha.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//
//        if (cozinha.isPresent()) {
//            return ResponseEntity.ok(cozinha.get());
//        }
////         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//         return ResponseEntity.notFound().build();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){
       return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public Cozinha atualizar(@PathVariable Long cozinhaId,
                                             @RequestBody Cozinha cozinha) {
        Cozinha cozinhaAtual = cadastroCozinha.buscarOuFalhar(cozinhaId);
        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");

        return cadastroCozinha.salvar(cozinhaAtual);
    }


//    @PutMapping("/{cozinhaId}")
//    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
//                                             @RequestBody Cozinha cozinha) {
//
//        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);
//
//        if (cozinhaAtual.isPresent()) {
//
//            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
//
//            Cozinha cozinhaSalva = cadastroCozinha.salvar(cozinhaAtual.get());
//            return ResponseEntity.ok(cozinhaSalva);
//        }
//
//        return ResponseEntity.notFound().build();
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{cozinhaId}")
    public void remover(@PathVariable Long cozinhaId) {
        cadastroCozinha.excluir(cozinhaId);
    }



//    @DeleteMapping("/{cozinhaId}")
//    public ResponseEntity<?> remover(@PathVariable Long cozinhaId) {
//        try {
//            cadastroCozinha.excluir(cozinhaId);
//            return ResponseEntity.noContent().build();
//
//        }
//        catch (EntidadeNaoEncontradaException e) {
//            return ResponseEntity.notFound().build();
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("N??o encontrado");
//
//        }
//        catch (EntidadeEmUsoException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//    }

}