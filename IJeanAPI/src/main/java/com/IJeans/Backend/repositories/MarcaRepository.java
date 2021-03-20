package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.model.MarcaModel;

public interface MarcaRepository extends JpaRepository<MarcaModel, Integer>{

	public List<MarcaModel> findAll();
}
