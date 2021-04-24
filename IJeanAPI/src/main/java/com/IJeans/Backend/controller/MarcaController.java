package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<MarcaModel>> getAll(){
		return ResponseEntity.ok().body(marcaService.findAll());
	}
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<String> cadastrar(@RequestBody MarcaModel marca){
		try {
			marcaService.cadastrarMarca(marca);
			return ResponseEntity.ok().body("Marca Cadastrada com Sucesso");
		}catch (Exception e){
			return ResponseEntity.ok().body("Erro ao Cadastrar Marca" + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<MarcaModel> deletar(@PathVariable("id") String id){
		try {
			;
			return ResponseEntity.ok().body(marcaService.deletar(id));
		}catch (Exception e){
			return ResponseEntity.ok().body(new MarcaModel());
		}
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	public ResponseEntity<MarcaModel> atualizar(@RequestBody MarcaModel marca){
		try {
			;
			return ResponseEntity.ok().body(marcaService.atualizar(marca));
		}catch (Exception e){
			return ResponseEntity.ok().body(new MarcaModel());
		}
	}
}
