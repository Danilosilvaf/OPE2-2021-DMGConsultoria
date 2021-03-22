package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.model.ProdutoModel;


public interface FuncionarioRepository  extends JpaRepository <FuncionarioModel, Integer>{

	FuncionarioModel findByLogin(String login);

	public List<FuncionarioModel> findAll();

	public FuncionarioModel findByNome(String descricao);
}
