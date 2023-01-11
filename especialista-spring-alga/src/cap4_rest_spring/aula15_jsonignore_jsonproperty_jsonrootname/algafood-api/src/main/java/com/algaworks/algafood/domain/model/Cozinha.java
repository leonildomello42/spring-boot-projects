package com.algaworks.algafood.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(schema = "algafood", name = "cozinha")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@JsonRootName("gastromia") //fica gastronomia no xml
public class Cozinha implements Serializable {

    @Serial
    private static final long serialVersionUID = -6920639314179796384L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonProperty("titulo")
//    @JsonIgnore
    @Column(name = "nome", length = 255, nullable = false)
    private String name;
}
