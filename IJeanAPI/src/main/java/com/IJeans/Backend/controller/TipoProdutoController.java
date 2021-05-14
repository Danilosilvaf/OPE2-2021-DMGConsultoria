package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.TipoProdutoModel;
import com.IJeans.Backend.service.TipoProdutoService;

@RestController
@RequestMapping(value = "/tipoProdutos")
public class TipoProdutoController {

	@Autowired
	private TipoProdutoService tipoProdutoService;

	@GetMapping
	public ResponseEntity<List<TipoProdutoModel>> getAll() {
		List<TipoProdutoModel> tipos = tipoProdutoService.findAll();
		if (tipos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(tipoProdutoService.findAll());
	}
}
