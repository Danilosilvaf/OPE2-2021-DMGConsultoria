package com.IJeans.Backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name= "produto")
public class ProdutoModel implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "preco_atual")
	private double preco_atual;
	
	@Column(name = "quantidade_estoque")
	private int quantidade_estoque;

	@OneToOne
	@JoinColumn(name = "id_marca")
	private MarcaModel marca;
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	
	
}
