package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer>{

	public List<ProdutoModel> findAll();

	public Page<ProdutoModel> findAll(PageRequest pageRequest);
}
