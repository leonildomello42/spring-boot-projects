package com.algaworks.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;


@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class Endereco implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "endereco_cep")
    private String cep;

    @Column(name = "endereco_logradouro")
    private String logradouro;

    @Column(name = "endereco_numero")
    private String numero;

    @Column(name = "endereco_complemento")
    private String complemento;

    @Column(name = "endereco_bairro")
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_cidade_id")
    private Cidade cidade;
}
