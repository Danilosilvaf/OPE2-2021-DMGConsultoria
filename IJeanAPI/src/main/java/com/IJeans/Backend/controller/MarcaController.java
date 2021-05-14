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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.MarcaModel;
import com.IJeans.Backend.model.ProdutoModel;
import com.IJeans.Backend.service.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;

	@GetMapping
	public ResponseEntity<List<MarcaModel>> getAll() {
		List<MarcaModel> marcas = marcaService.findAll();
		if (marcas.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(marcaService.findAll());
	}

	@PostMapping
	public ResponseEntity<String> cadastrar(@RequestBody MarcaModel marca) {
		try {
			marcaService.cadastrarMarca(marca);
			return ResponseEntity.ok().body("Marca Cadastrada com Sucesso");
		} catch (Exception e) {
			return ResponseEntity.ok().body("Erro ao Cadastrar Marca" + e.getMessage());
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MarcaModel> deletar(@PathVariable("id") String id) {
		try {
			;
			return ResponseEntity.ok().body(marcaService.deletar(id));
		} catch (Exception e) {
			return ResponseEntity.ok().body(new MarcaModel());
		}
	}

	@PutMapping
	public ResponseEntity<MarcaModel> atualizar(@RequestBody MarcaModel marca) {
		try {
			;
			return ResponseEntity.ok().body(marcaService.atualizar(marca));
		} catch (Exception e) {
			return ResponseEntity.ok().body(new MarcaModel());
		}
	}
}
