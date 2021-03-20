package com.IJeans.Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipoproduto")
public class TipoProdutoModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOPRODUTO_NAME_SEQ")
    @SequenceGenerator(sequenceName = "tipoproduto_seq", allocationSize = 1, name = "TIPOPRODUTO_NAME_SEQ")
	private String id;
	
	@Column(name = "nome")
	private String nome;
	
	public TipoProdutoModel(String id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	private TipoProdutoModel() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
