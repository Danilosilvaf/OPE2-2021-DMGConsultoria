package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
>>>>>>> c53cb8ba4701ba7a15791285d35b2aa63d46248d
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.FuncionarioModel;
import com.IJeans.Backend.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public ResponseEntity<List<FuncionarioModel>> getAll(){
		List<FuncionarioModel> funcionarios = funcionarioService.findAll();
		if (funcionarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(funcionarioService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioModel> cadastrarFuncionario(@RequestBody FuncionarioModel funcionario){
			funcionarioService.cadastrarFuncionario(funcionario);
			return ResponseEntity.ok().body(funcionario);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FuncionarioModel> deletar(@PathVariable("id") String id){
		try {
			;
			return ResponseEntity.ok().body(funcionarioService.deletar(id));
		}catch (Exception e){
			return ResponseEntity.ok().body( new FuncionarioModel());
		}
	}
	
	@PutMapping
	public ResponseEntity<FuncionarioModel> atualizar(@RequestBody FuncionarioModel Funcionario){
		try {
			;
			return ResponseEntity.ok().body(funcionarioService.atualizar(Funcionario));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
}
