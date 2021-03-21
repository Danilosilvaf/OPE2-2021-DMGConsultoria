package com.IJeans.Backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.service.AutenticacaoService;




@RestController
@RequestMapping(value = "/")
public class AutenticacaoController {
	
	@Autowired
	private AutenticacaoService autService;
	
	
	@RequestMapping(value = "/autenticacao",method = RequestMethod.POST)
	public ResponseEntity<FuncionarioModel> validarLogin(@RequestBody FuncionarioModel model) {
				return ResponseEntity.ok().body(autService.doLogin(model.getLogin(), model.getSenha()));
		
	}
}
