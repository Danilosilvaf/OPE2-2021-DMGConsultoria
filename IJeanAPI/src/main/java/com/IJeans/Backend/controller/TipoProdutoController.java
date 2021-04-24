package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.TipoProdutoModel;
import com.IJeans.Backend.service.TipoProdutoService;

@RestController
@RequestMapping(value ="/tipoProdutos")
@CrossOrigin(origins = "*")
public class TipoProdutoController {

	@Autowired
	private TipoProdutoService tipoProdutoService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public ResponseEntity<List<TipoProdutoModel>> getAll(){
		return ResponseEntity.ok().body(tipoProdutoService.findAll());
	}
}
