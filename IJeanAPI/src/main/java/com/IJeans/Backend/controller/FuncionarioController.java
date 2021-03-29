package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<FuncionarioModel>> getAll(){
		return ResponseEntity.ok().body(funcionarioService.findAll());
	}
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<FuncionarioModel> cadastrarFuncionario(@RequestBody FuncionarioModel funcionario){
			funcionarioService.cadastrarFuncionario(funcionario);
			return ResponseEntity.ok().body(funcionario);
		}
	}
