package com.IJeans.Backend.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.model.FornecedorModel;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Integer>{

	@Query(
			value="SELECT * FROM fornecedor WHERE STATUS <> false",
			nativeQuery=true)
	public List<FornecedorModel> findAll();
	
	@Transactional
	public void deleteById(int id);

	public Optional<FornecedorModel> findById(String id);
	
	
	
	@Query(
			value="SELECT * FROM fornecedor WHERE STATUS <> false",
			nativeQuery=true)
	public Optional<List<FornecedorModel>> findByNomeContaining(String nomeBusca);

}
