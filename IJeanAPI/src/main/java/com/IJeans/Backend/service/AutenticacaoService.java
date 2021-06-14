package com.IJeans.Backend.service;

import com.IJeans.Backend.model.FuncionarioModel;

public interface AutenticacaoService {
	public FuncionarioModel doLogin(String usuario, String senha)  ;
	
	public void useDatabase();
}
