package com.IJeans.Backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.FornecedorModel;
import com.IJeans.Backend.model.MarcaModel;
import com.IJeans.Backend.service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
@CrossOrigin(origins = "*")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<FornecedorModel>> getAll(){
		return ResponseEntity.ok().body(fornecedorService.findAll());
	}
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public ResponseEntity<FornecedorModel> cadastrar(@RequestBody FornecedorModel fornecedor){
			fornecedorService.cadastrarFornecedor(fornecedor);
			return ResponseEntity.ok().body(fornecedor);
		
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<FornecedorModel> deletar(@PathVariable("id") String id){
		try {
			;
			return ResponseEntity.ok().body(fornecedorService.deletar(id));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "",method = RequestMethod.PUT)
	public ResponseEntity<FornecedorModel> atualizar(@RequestBody FornecedorModel fornecedor){
		try {
			;
			return ResponseEntity.ok().body(fornecedorService.atualizar(fornecedor));
		}catch (Exception e){
			return ResponseEntity.badRequest().build();
		}
	}
}
