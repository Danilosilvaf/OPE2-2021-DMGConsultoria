package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.model.TamanhoModel;

public interface TamanhoRepository extends JpaRepository<TamanhoModel, String>{

	public List<TamanhoModel> findAll();
	
}
