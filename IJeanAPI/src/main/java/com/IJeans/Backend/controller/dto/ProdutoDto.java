package com.IJeans.Backend.controller.dto;

import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.model.ProdutoModel;

public class ProdutoDto {

	private boolean status;
	private double precoCompra;
	private ProdutoModel produto;
	private FornecedorModel fornecedor;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public ProdutoDto(boolean status, double precoCompra, ProdutoModel produto, FornecedorModel fornecedor) {
		super();
		this.status = status;
		this.precoCompra = precoCompra;
		this.produto = produto;
		this.fornecedor = fornecedor;
	}
	
}
