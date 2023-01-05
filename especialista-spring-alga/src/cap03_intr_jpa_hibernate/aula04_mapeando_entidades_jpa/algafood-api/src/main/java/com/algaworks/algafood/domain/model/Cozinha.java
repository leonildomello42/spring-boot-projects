package com.algaworks.algafood.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(schema = "algafood" , name = "tab_cozinhas")
public class Cozinha implements Serializable {

	@Serial
	private static final long serialVersionUID = -1L;

	@Id
	private Long id;

	@Column(name = "nom_cozinha", length = 255)
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Cozinha cozinha = (Cozinha) o;
		return id.equals(cozinha.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
