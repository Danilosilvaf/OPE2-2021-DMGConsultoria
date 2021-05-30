package com.IJeans.Backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer>{

	@Query(
			value="SELECT * FROM produto WHERE STATUS <> false",
			nativeQuery=true)
	public List<ProdutoModel> findAll();

	public ProdutoModel findByNome(String descricao);
	
	public Optional<ProdutoModel> findById(String id);

	public Optional<ProdutoModel> findByNomeContaining(String nomeBusca);

}
