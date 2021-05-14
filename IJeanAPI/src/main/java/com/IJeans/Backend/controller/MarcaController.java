package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> c53cb8ba4701ba7a15791285d35b2aa63d46248d
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.MarcaModel;
import com.IJeans.Backend.service.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {

	@Autowired
	private MarcaService marcaService;
<<<<<<< HEAD

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
=======
	
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<MarcaModel>> getAll(){
		return ResponseEntity.ok().body(marcaService.findAll());
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<String> cadastrar(@RequestBody MarcaModel marca){
>>>>>>> c53cb8ba4701ba7a15791285d35b2aa63d46248d
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
<<<<<<< HEAD
		} catch (Exception e) {
			return ResponseEntity.ok().body(new MarcaModel());
=======
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
>>>>>>> c53cb8ba4701ba7a15791285d35b2aa63d46248d
		}
	}

	@PutMapping
	public ResponseEntity<MarcaModel> atualizar(@RequestBody MarcaModel marca) {
		try {
			;
			return ResponseEntity.ok().body(marcaService.atualizar(marca));
<<<<<<< HEAD
		} catch (Exception e) {
			return ResponseEntity.ok().body(new MarcaModel());
=======
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
>>>>>>> c53cb8ba4701ba7a15791285d35b2aa63d46248d
		}
	}
}
