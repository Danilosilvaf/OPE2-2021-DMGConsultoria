package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<FuncionarioModel> deletar(@PathVariable("id") String id){
		try {
			;
			return ResponseEntity.ok().body(funcionarioService.deletar(id));
		}catch (Exception e){
			return ResponseEntity.ok().body( new FuncionarioModel());
		}
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	public ResponseEntity<FuncionarioModel> atualizar(@RequestBody FuncionarioModel Funcionario){
		try {
			;
			return ResponseEntity.ok().body(funcionarioService.atualizar(Funcionario));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
}
