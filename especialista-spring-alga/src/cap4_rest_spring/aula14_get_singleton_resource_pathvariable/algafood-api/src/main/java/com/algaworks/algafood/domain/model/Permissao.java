package com.algaworks.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Permissao implements Serializable{

    @Serial
    private static final long serialVersionUID = 8589970076800323522L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;
}

