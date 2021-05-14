package com.IJeans.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.model.TamanhoModel;
import com.IJeans.Backend.service.TamanhoService;

@RestController
@RequestMapping(value = "/tamanhos")
public class TamanhoController {

	@Autowired
	private TamanhoService tamanhoService;
	
	@GetMapping
	public ResponseEntity<List<TamanhoModel>> getAll(){
		List<TamanhoModel> tamanhos = tamanhoService.findAll();
		if (tamanhos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(tamanhoService.findAll());
	}
}
