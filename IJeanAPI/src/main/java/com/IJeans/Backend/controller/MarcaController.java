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

import com.IJeans.Backend.model.MarcaModel;
import com.IJeans.Backend.service.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
@CrossOrigin(origins = "*")
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
	
	@GetMapping(value = "/nome/{nomeBusca}")
	public ResponseEntity<Optional<MarcaModel>> findByNome(@PathVariable("nomeBusca") String nomeBusca){
		Optional<MarcaModel> nome = marcaService.findByNomeContaining(nomeBusca);
		if(!nome.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(marcaService.findByNomeContaining(nomeBusca));
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<MarcaModel> cadastrar(@Valid @RequestBody MarcaModel marca) {
		marcaService.cadastrarMarca(marca);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<MarcaModel> deletar(@PathVariable("id") String id) {
		Optional<MarcaModel> optional = marcaService.findById(id);
		if (optional.isPresent()) {
			try {
				marcaService.deletar(optional.get());
				return ResponseEntity.ok().build();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping
	public ResponseEntity<MarcaModel> atualizar(@Valid @RequestBody MarcaModel marca) {
		Optional<MarcaModel> optional = marcaService.findById(marca.getId());
		if (optional.isPresent()) {
			marcaService.atualizar(marca);
			return ResponseEntity.ok().body(marca);
		}
		return ResponseEntity.notFound().build();
	}
}
