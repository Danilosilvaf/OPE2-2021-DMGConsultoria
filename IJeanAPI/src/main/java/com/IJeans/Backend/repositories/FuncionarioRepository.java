package com.IJeans.Backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.model.FuncionarioModel;


public interface FuncionarioRepository  extends JpaRepository <FuncionarioModel, Integer>{

	FuncionarioModel findByLogin(String login);

	public List<FuncionarioModel> findAll();

	public FuncionarioModel findByNome(String nome);

	Optional<FuncionarioModel> findById(String id);
	
	void deleteById(String id);

	Optional<List<FuncionarioModel>> findByNomeContaining(String nomeBusca);

	@Query(
			value="use ijeans",
			nativeQuery=true)
	void useDatabase();
}
