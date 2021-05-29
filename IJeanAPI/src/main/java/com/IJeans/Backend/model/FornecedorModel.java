package com.IJeans.Backend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fornecedor")
public class FornecedorModel implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	
	@Column(name = "nome")
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull @Size(min = 3, max = 25)
	private String nome;
	
	@Column(name = "email")
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email @NotNull
	private String email;
	
	@Column(name = "telefone")
	@NotEmpty(message = "Preenchimento obrigatório")
	@NotNull @Size(min = 10, max = 11)
	private String telefone;
	
	@Column(name = "status")
	private boolean status;
	
	public FornecedorModel() {
		
	}

	public FornecedorModel(String id, String nome, String email, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
