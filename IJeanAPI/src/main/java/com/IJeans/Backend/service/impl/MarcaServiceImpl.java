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
	public MarcaModel deletar(String id) {
			Optional<MarcaModel> marcaretorno = marcaRepository.findById(id);
			
			MarcaModel marca = marcaretorno.get();
			if(marcaretorno != null){
				
				marca.setStatus(false);
				marcaRepository.save(marca);
				return marca;
			}
			return new MarcaModel();
			
		}

	@Override
	public MarcaModel atualizar(MarcaModel marca) {
			Optional<MarcaModel> marcaretorno = marcaRepository.findById(marca.getId());
			
			if(marcaretorno.isPresent()) {
				this.marcaRepository.save(marca);
				return marca;
			}
			return new MarcaModel();
		}

}
