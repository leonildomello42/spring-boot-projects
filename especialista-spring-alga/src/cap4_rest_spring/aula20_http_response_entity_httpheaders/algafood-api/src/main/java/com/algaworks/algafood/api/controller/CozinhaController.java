package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.api.model.CozinhaXmlWrapper;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody

@RestController
//@RequestMapping(value = "/cozinhas", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

//    @GetMapping(produces = "application/json")
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhaXmlWrapper listarXml(){
        return new CozinhaXmlWrapper(cozinhaRepository.listar());
    }

//    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
//    public List<Cozinha> listar2(){
//        System.out.println("Listar 2");
//        return cozinhaRepository.listar();
//    }

/*
    @GetMapping(value = "/{cozinhaId}")
    public Cozinha buscar(@PathVariable("cozinhaId") Long id) {
        return cozinhaRepository.buscar(id);
    }
*/


    @GetMapping(value = "/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {

        Cozinha cozinha =  cozinhaRepository.buscar(cozinhaId);

//        return ResponseEntity.ok(cozinha);
//        return ResponseEntity.status(HttpStatus.OK).body(cozinha);
//        return ResponseEntity.status(HttpStatus.OK).build();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas/");

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .headers(headers)
                .build();
    }
}
