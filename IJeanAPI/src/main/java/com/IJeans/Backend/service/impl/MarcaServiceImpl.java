package com.IJeans.Backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.MarcaModel;
import com.IJeans.Backend.repositories.MarcaRepository;
import com.IJeans.Backend.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public List<MarcaModel> findAll() {
		return marcaRepository.findAll();
	}

	@Override
	public void cadastrarMarca(MarcaModel marca) {
		marcaRepository.save(marca);
	}

	@Override
	public void deletar(MarcaModel marca) {
		marca.setStatus(false);
		this.marcaRepository.save(marca);
	}
	
	@Override
	public void atualizar(MarcaModel marca) {
		this.marcaRepository.save(marca);
	}
	
	@Override
	public Optional<MarcaModel> findById(String id) {
		return marcaRepository.findById(id);
	}

}
