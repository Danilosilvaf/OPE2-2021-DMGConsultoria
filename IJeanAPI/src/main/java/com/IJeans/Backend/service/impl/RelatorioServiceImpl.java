package com.IJeans.Backend.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.repositories.MovimentacaoDeEstoqueRepository;
import com.IJeans.Backend.service.RelatorioService;
@Service
public class RelatorioServiceImpl implements RelatorioService {
	@Autowired
	MovimentacaoDeEstoqueRepository repository;

	@Override
	public List<Object[]> findAllRelatorio() {

		return repository.relatorio();
	}

}
