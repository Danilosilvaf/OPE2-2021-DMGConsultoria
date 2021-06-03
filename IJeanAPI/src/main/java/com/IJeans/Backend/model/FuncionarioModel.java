package com.IJeans.Backend.model;

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
@Table(name = "funcionario")
public class FuncionarioModel {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "login")
	@NotNull 
	private String login;

	@Column(name = "senha")
	@NotNull
	private String senha;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@Column(name = "email")
	@NotNull
	private String email;

	@Column(name = "nivel_func")
	@NotNull 
	private int nivelFunc;

	public FuncionarioModel() {
	}

	public FuncionarioModel(String id, String login, String senha, String nome, String email,int nivelFunc) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.nivelFunc = nivelFunc;
	}

	public int getNivelFunc() {
		return nivelFunc;
	}

	public void setNivelFunc(int nivelFunc) {
		this.nivelFunc = nivelFunc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
