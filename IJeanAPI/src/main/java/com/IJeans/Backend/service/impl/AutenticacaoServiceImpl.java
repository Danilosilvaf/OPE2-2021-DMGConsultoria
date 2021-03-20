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
		
		
		FuncionarioModel login = repository.findByLogin(usuario);
		
		if(login == null) {
			return "Usuário Inválido";
		}else {
			if(login.getLogin().equals(usuario) && login.getSenha().equals(senha)) {
				return "Usuário Logado com sucesso!";	
			}else {
				return "Usuário Inválido";
			}
	
		}
		
		
		
	}
	
}
