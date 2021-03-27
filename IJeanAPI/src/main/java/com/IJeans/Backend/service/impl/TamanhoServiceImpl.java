package com.IJeans.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.TamanhoModel;
import com.IJeans.Backend.repositories.TamanhoRepository;
import com.IJeans.Backend.service.TamanhoService;

@Service
public class TamanhoServiceImpl implements TamanhoService {

	@Autowired
	private TamanhoRepository tamanhoRepository;
	
	@Override
	public List<TamanhoModel> findAll() {
		return tamanhoRepository.findAll();
	}
}
