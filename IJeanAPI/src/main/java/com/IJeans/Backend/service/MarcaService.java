package com.IJeans.Backend.service;

import java.util.List;
import java.util.Optional;

import com.IJeans.Backend.model.MarcaModel;

public interface MarcaService {

	List<MarcaModel> findAll();
	
	void cadastrarMarca(MarcaModel marca);

	void atualizar(MarcaModel marca);

	Optional<MarcaModel> findById(String id);

	void deletar(MarcaModel marcaModel);

	Optional<MarcaModel> findByNomeContaining(String nomeBusca);

}

