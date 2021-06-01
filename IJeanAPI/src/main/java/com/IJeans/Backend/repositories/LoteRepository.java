package com.IJeans.Backend.repositories;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.model.LoteModel;

import java.util.List;
import java.util.Optional;

public interface LoteRepository extends JpaRepository<LoteModel, Integer> {

	void save(@Valid EstoqueDto transacao);

	@Query(
			value="SELECT * FROM lote WHERE id_produto = ?",
			nativeQuery=true)
	Optional<List<LoteModel>> findByIdProduto(String a);
	
	
			

}
