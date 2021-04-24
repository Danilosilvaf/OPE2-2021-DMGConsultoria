package com.IJeans.Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tamanho")
public class TamanhoModel {

	@Id
	@Column(name = "id")
	private String id;
	
	@Column(name= "id_tipo")
	private int tipo_produto;

	public TamanhoModel() {}
	

	public TamanhoModel(String id, int tipo_produto) {
		super();
		this.id = id;
		this.tipo_produto = tipo_produto;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(int tipo_produto) {
		this.tipo_produto = tipo_produto;
	}
	
	
	
	
}