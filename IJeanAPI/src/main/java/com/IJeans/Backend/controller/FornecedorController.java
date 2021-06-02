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

import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
@CrossOrigin(origins = "*")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping
	public ResponseEntity<List<FornecedorModel>> getAll() {
		List<FornecedorModel> fornecedores = fornecedorService.findAll();
		if (fornecedores.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(fornecedorService.findAll());
	}
	
	@GetMapping(value = "/nome/{nomeBusca}")
	public ResponseEntity<Optional<List<FornecedorModel>>> findByNome(@PathVariable("nomeBusca") String nomeBusca){
		Optional<List<FornecedorModel>> nome = fornecedorService.findByNomeContaining(nomeBusca);
		if(!nome.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(fornecedorService.findByNomeContaining(nomeBusca));
	}

	@PostMapping
	public ResponseEntity<FornecedorModel> cadastrar(@Valid @RequestBody FornecedorModel fornecedor) {
		fornecedorService.cadastrarFornecedor(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<FornecedorModel> deletar(@PathVariable("id") String id) {
		Optional<FornecedorModel> optional = fornecedorService.findById(id);
		if (optional.isPresent()) {
			try {
				fornecedorService.deletar(optional.get());
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping
	public ResponseEntity<FornecedorModel> atualizar(@Valid @RequestBody FornecedorModel fornecedor) {
		Optional<FornecedorModel> optional = fornecedorService.findById(fornecedor.getId());
		if (optional.isPresent()) {
			fornecedorService.atualizar(fornecedor);
			return ResponseEntity.ok().body(fornecedor);
		}
		return ResponseEntity.notFound().build();
	}
}
