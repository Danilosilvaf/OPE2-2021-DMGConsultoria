package com.IJeans.Backend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.controller.dto.ProdutoDto;
import com.IJeans.Backend.exception.ProdutoExistenteException;
import com.IJeans.Backend.model.MovimentacaoDeEstoqueModel;
import com.IJeans.Backend.model.ProdutoModel;
import com.IJeans.Backend.service.EstoqueService;
import com.IJeans.Backend.service.MovimentacaoDeEstoqueService;
import com.IJeans.Backend.service.ProdutosService;

@RestController
@RequestMapping(value = "/estoque")
@CrossOrigin(origins = "*")
public class MovimentacaoDeEstoqueController {

	@Autowired
	private MovimentacaoDeEstoqueService movimentacaoService;
	
	@Autowired
	private EstoqueService estoqueService;
	
	@Autowired
	private ProdutosService produtosService;
	
	@GetMapping
	public ResponseEntity<List<MovimentacaoDeEstoqueModel>> getAll() {
		List<MovimentacaoDeEstoqueModel> transacoes = movimentacaoService.findAll();
		if (transacoes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(movimentacaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id){
		return ResponseEntity.ok().body(movimentacaoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDto> registrarTransacao(@Valid @RequestBody EstoqueDto transacao) throws Exception {
		if(transacao.isStatus()) {
			estoqueService.registrarTransacao(transacao);
		}else {
			estoqueService.registrarVenda(transacao);
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
	@PostMapping(value = "/novoProduto")
	public  ResponseEntity<ProdutoModel> cadastrarNovoProduto(@Valid @RequestBody ProdutoDto produto) throws Exception {
		Optional<ProdutoModel> prod = produtosService.findByNomeContaining(produto.getProduto().getNome());
		
		if(prod.isPresent()) {
			throw new ProdutoExistenteException("Produto já cadastrado no sistema.");
		}
		produto.setStatus(true);
		 produtosService.cadastrarNovoProduto(produto);
		 return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}