package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.model.TipoProdutoModel;

public interface TipoProdutoRepository extends JpaRepository<TipoProdutoModel, String>{

	public List<TipoProdutoModel> findAll();
}
