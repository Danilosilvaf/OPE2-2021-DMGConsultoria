package com.IJeans.Backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.repositories.FuncionarioRepository;
import com.IJeans.Backend.service.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {
	
	@Autowired
	FuncionarioRepository repository;
	
		 
	public String doLogin(String usuario, String senha)  {
		
		
		FuncionarioModel lst = repository.findByLogin(usuario);
		
		if(lst.equals("") || lst.equals(null))
			return "Usuario invalido";
		else
			return "Usuario logado";
				
		
		
	}
	
}
