package com.IJeans.Backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "lote")
public class LoteModel {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "quantidade")
	private int quantidade;
	
	@Column(name = "preco_compra")
	private double precoCompra;
	
	@OneToOne
	@JoinColumn(name = "id_produto")
	private ProdutoModel produto;
	
	@OneToOne
	@JoinColumn(name = "id_fornecedor")
	private FornecedorModel fornecedor;
	
	
	
	public LoteModel() {}
	
	
	

	public LoteModel(int id, int quantidade, double precoCompra, ProdutoModel produto, FornecedorModel fornecedor) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.precoCompra = precoCompra;
		this.produto = produto;
		this.fornecedor = fornecedor;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPrecoCompra() {
		return precoCompra;
	}

	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public FornecedorModel getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorModel fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	
	
	
	
}
