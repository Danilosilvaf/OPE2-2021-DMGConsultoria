package com.IJeans.Backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.repositories.FuncionarioRepository;
import com.IJeans.Backend.service.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {
	
	@Autowired
	FuncionarioRepository repository;
	
		 
	public FuncionarioModel doLogin(String usuario, String senha)  {
		
		
		FuncionarioModel login = repository.findByLogin(usuario);
		
		if(login == null) {
			return new FuncionarioModel();
		}else {
			if(login.getLogin().equals(usuario) && login.getSenha().equals(senha)) {
				return login;	
			}else {
				return new FuncionarioModel();
			}
	
		}
	}


	@Override
	public void useDatabase() {
		repository.useDatabase();
	}
}
