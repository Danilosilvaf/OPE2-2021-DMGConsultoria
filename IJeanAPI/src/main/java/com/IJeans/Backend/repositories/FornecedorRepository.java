package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.model.FornecedorModel;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Integer>{

	public List<FornecedorModel> findAll();
}
