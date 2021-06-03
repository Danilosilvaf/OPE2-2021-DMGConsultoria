package com.IJeans.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.model.MovimentacaoDeEstoqueModel;

public interface MovimentacaoDeEstoqueRepository extends JpaRepository<MovimentacaoDeEstoqueModel, String>{

	void save(EstoqueDto transacao);
	
	@Query(
			value="SELECT m.quantidade,m.valor_unitario,m.tipo_transacao,m.`DATA`,l.preco_compra,p.nome,p.id FROM movimentacao m ,lote l ,produto p WHERE m.id_lote = l.id AND l.id_produto = p.id ORDER BY p.id",
			nativeQuery=true)
	List<Object[]> relatorio();

}
