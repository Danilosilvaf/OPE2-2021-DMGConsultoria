package com.IJeans.Backend.service;

import java.util.List;

import com.IJeans.Backend.model.MarcaModel;

public interface MarcaService {

	List<MarcaModel> findAll();
	
	void cadastrarMarca(MarcaModel marca);

	MarcaModel deletar(String id);

	MarcaModel atualizar(MarcaModel marca);
}
