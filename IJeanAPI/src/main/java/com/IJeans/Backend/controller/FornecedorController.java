package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public ResponseEntity<List<FornecedorModel>> getAll(){
		List<FornecedorModel> fornecedores = fornecedorService.findAll();
		if (fornecedores.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(fornecedorService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<FornecedorModel> cadastrar(@RequestBody FornecedorModel fornecedor){
			fornecedorService.cadastrarFornecedor(fornecedor);
			return ResponseEntity.ok().body(fornecedor);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<FornecedorModel> deletar(@PathVariable("id") String id){
		try {
			;
			return ResponseEntity.ok().body(fornecedorService.deletar(id));
		}catch (Exception e){
			return ResponseEntity.ok().body( new FornecedorModel());
		}
	}
	
	@PutMapping
	public ResponseEntity<FornecedorModel> atualizar(@RequestBody FornecedorModel fornecedor){
		try {
			;
			return ResponseEntity.ok().body(fornecedorService.atualizar(fornecedor));
		}catch (Exception e){
			return ResponseEntity.ok().body(new FornecedorModel());
		}
	}
}
