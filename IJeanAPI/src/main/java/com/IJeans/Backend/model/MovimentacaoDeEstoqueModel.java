package com.IJeans.Backend.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "movimentacao")
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
	
	@Column(name = "tipo_transacao")
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull @Length(max = 1)
	private boolean status;

	@OneToOne
	@JoinColumn(name = "id_lote")
	private LoteModel lote;
	
	@Column(name = "DATA")
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataTransacao = LocalDateTime.now();
	
	public MovimentacaoDeEstoqueModel() {
	}

	public MovimentacaoDeEstoqueModel(String id, double valor_unitario, int quantidade, boolean status) {
		this.id = id;
		this.valor_unitario = valor_unitario;
		this.quantidade = quantidade;
		this.status = status;
	}

	public LoteModel getLote() {
		return lote;
	}

	public void setLote(LoteModel lote) {
		this.lote = lote;
	}

	public LocalDateTime getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(LocalDateTime dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
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
