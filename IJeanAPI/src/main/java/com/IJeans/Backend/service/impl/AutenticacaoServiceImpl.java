package com.IJeans.Backend.service.impl;

import org.springframework.stereotype.Service;

import com.IJeans.Backend.service.AutenticacaoService;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {
		 
	public String doLogin(String usuario, String senha)  {
		
		if(!usuario.equals("a"))
			return "Usuario invalido";
		if(!senha.equals("a"))
			return "Usuario invalido";
		
		return "Usuario logado";
	}
	
}
