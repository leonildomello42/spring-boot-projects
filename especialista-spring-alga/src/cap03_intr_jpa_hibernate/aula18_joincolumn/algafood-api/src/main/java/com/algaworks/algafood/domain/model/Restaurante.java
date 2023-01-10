package com.algaworks.algafood.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(schema = "algafood", name = "restaurante")
public class Restaurante implements Serializable {

    private static final long serialVersionUID = -775678829848020064L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    //Muitos restaurantes tem uma cozinha
    @ManyToOne
    @JoinColumn(name = "cozinha_id")
    private Cozinha cozinha;
}
