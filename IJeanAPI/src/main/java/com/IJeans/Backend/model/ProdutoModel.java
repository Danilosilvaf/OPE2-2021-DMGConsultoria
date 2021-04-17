package com.IJeans.Backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "produto")
public class ProdutoModel implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "preco_atual")
	private double preco_atual;
	
	@Column(name = "quantidade_estoque")
	private int quantidade_estoque;

	@OneToOne
	@JoinColumn(name = "id_marca")
	private MarcaModel marca;
	
	@Column(name = "status")
	private boolean status;
	
	@OneToOne
	@JoinColumn(name = "id_tipo")
	private TipoProdutoModel tipo_produto;
	
	@OneToOne
	@JoinColumn(name = "id_tamanho")
	
	
	
	private TamanhoModel tamanho;
	
	public TamanhoModel getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoModel tamanho) {
		this.tamanho = tamanho;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MarcaModel getMarca() {
		return marca;
	}

	public void setMarca(MarcaModel marca) {
		this.marca = marca;
	}

	public TipoProdutoModel getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(TipoProdutoModel tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco_atual() {
		return preco_atual;
	}

	public void setPreco_atual(double preco_atual) {
		this.preco_atual = preco_atual;
	}

	public int getQuantidade_estoque() {
		return quantidade_estoque;
	}

	public void setQuantidade_estoque(int quantidade_estoque) {
		this.quantidade_estoque = quantidade_estoque;
	}

	public boolean getStatus() {
		return this.status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
