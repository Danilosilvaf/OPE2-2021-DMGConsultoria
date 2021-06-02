package com.IJeans.Backend.controller.dto;

import com.IJeans.Backend.exception.NumeroNegativoException;
import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.model.ProdutoModel;

public class EstoqueDto {

	private int quantidade;
	private boolean status;
	private double precoTransacao;
	private ProdutoModel produto;
	private FornecedorModel fornecedor;
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public double getPreco() {
		return precoTransacao;
	}
	public void setPreco(double preco) {
		this.precoTransacao = preco;
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
	
	
	
	public EstoqueDto(int quantidade, boolean status, double preco, ProdutoModel produto, FornecedorModel fornecedor) {
		super();
		this.quantidade = quantidade;
		this.status = status;
		this.precoTransacao = preco;
		this.produto = produto;
		this.fornecedor = fornecedor;
	}
	
	private boolean validacao() {
		if(this.quantidade > this.produto.getQuantidade_estoque()) {
			return false;
		} return true;
	}
	
	public void calcularQuantidade() throws Exception {
		if(this.quantidade <= 0) {
			throw new NumeroNegativoException("Numeros negativos nao permitidos");
		}
		if(this.isStatus()){
			this.produto.setQuantidade_estoque(this.quantidade + this.produto.getQuantidade_estoque());
		} else {
			if (validacao()) { 
			this.produto.setQuantidade_estoque(this.produto.getQuantidade_estoque() - this.quantidade);
			}
		}
	}
}
