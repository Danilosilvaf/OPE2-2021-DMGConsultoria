package com.IJeans.Backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movimentacaoestoque")
public class MovimentacaoDeEstoqueModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "valor_unitario")
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull @Size(min = 1, max = 10)
	private double valor_unitario;
	
	@Column(name = "quantidade")
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull @Size(min = 1, max = 10)
	private int quantidade;

	@Enumerated(EnumType.STRING)
	@NotNull @NotEmpty(message = "Preenchimento obrigatório")
	private StatusTransacao status;

	public MovimentacaoDeEstoqueModel() {
	}

	public MovimentacaoDeEstoqueModel(String id, double valor_unitario, int quantidade, StatusTransacao status) {
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.quantidade = quantidade;
		this.status = status;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final double getValor_unitario() {
		return valor_unitario;
	}

	public final void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public final int getQuantidade() {
		return quantidade;
	}

	public final void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public final StatusTransacao getStatus() {
		return status;
	}

	public final void setStatus(StatusTransacao status) {
		this.status = status;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovimentacaoDeEstoqueModel other = (MovimentacaoDeEstoqueModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
