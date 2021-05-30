package com.IJeans.Backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<List<FuncionarioModel>> getAll() {
		List<FuncionarioModel> funcionarios = funcionarioService.findAll();
		if (funcionarios.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(funcionarioService.findAll());
	}
	
	@GetMapping(value = "/nome/{nomeBusca}")
	public ResponseEntity<Optional<FuncionarioModel>> findByNome(@PathVariable("nomeBusca") String nomeBusca){
		Optional<FuncionarioModel> nome = funcionarioService.findByNomeContaining(nomeBusca);
		if(!nome.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(funcionarioService.findByNomeContaining(nomeBusca));
	}

	@PostMapping
	public ResponseEntity<FuncionarioModel> cadastrarFuncionario(@Valid @RequestBody FuncionarioModel funcionario) {
		funcionarioService.cadastrarFuncionario(funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<FuncionarioModel> deletar(@PathVariable("id") String id) {
		Optional<FuncionarioModel> optional = funcionarioService.findById(id);
		if (optional.isPresent()) {
			try {
				funcionarioService.deletar(optional.get());
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping
	public ResponseEntity<FuncionarioModel> atualizar(@Valid @RequestBody FuncionarioModel funcionario) {
		Optional<FuncionarioModel> optional = funcionarioService.findById(funcionario.getId());
		if (optional.isPresent()) {
			funcionarioService.atualizar(funcionario);
			return ResponseEntity.ok().body(funcionario);
		}
		return ResponseEntity.notFound().build();
	}
}
