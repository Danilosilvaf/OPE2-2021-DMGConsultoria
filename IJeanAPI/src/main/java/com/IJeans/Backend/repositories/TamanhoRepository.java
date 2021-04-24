package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.model.TamanhoModel;

public interface TamanhoRepository extends JpaRepository<TamanhoModel, String>{

	public List<TamanhoModel> findAll();

	@Query(
			value="SELECT * FROM tamanho WHERE id_tipo = ?",
			nativeQuery=true)
	public List<TamanhoModel> findByIdTipo(String id);
	
}
