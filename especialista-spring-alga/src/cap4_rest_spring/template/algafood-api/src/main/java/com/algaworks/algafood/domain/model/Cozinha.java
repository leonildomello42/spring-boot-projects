package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonRootName("Cozinha") //fica gastronomia no xml
public class Cozinha implements Serializable {

    private static final long serialVersionUID = -6920639314179796384L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonProperty("titulo")
//    @JsonIgnore
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;
}
