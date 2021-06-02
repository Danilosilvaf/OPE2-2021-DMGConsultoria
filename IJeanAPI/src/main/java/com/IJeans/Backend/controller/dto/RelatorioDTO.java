package com.IJeans.Backend.controller.dto;

public class RelatorioDTO {

	private int quantidade;
	private float valor_unitario;
	private String tipo_transacao;
	private String data;
	private float preco_compra;
	private String nome;
	private int id;
	
	
	
	
	
	public RelatorioDTO(Object[] obj) {
		this.quantidade =(int) obj[0];
		this.valor_unitario = (float) obj[1];
		 boolean compraVenda= (boolean) obj[2];
		 if(compraVenda) {
			 this.tipo_transacao="Compra";
		 }else {
			 this.tipo_transacao="Venda";
		 }
		this.data = ""+ obj[3];
		this.preco_compra = (float) obj[4];
		this.nome = ""+ obj[5];
		this.id = (int) obj[6];
	}
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public String getTipo_transacao() {
		return tipo_transacao;
	}
	public void setTipo_transacao(String tipo_transacao) {
		this.tipo_transacao = tipo_transacao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public float getPreco_compra() {
		return preco_compra;
	}
	public void setPreco_compra(float preco_compra) {
		this.preco_compra = preco_compra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public String[] Imprimir() {
		String[] item1 ={""+this.getNome(),""+this.getTipo_transacao(),""+this.getValor_unitario(),""+this.getQuantidade(),this.getData()};
		return  item1;
	}
	
	
	
	
}
