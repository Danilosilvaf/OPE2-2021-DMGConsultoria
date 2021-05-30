package com.IJeans.Backend.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.model.MarcaModel;

public interface MarcaRepository extends JpaRepository<MarcaModel, Integer>{

	@Query(
			value="SELECT * FROM marca WHERE STATUS <> false",
			nativeQuery=true)
	public List<MarcaModel> findAll();

	public Optional<MarcaModel> findById(String id);
	
	@Transactional
	public void deleteById(String id);

	public Optional<MarcaModel> findByNomeContaining(String nomeBusca);
}
