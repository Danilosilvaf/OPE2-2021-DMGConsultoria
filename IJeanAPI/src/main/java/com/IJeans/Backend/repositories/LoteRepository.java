package com.IJeans.Backend.repositories;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IJeans.Backend.controller.dto.EstoqueDto;
import com.IJeans.Backend.model.LoteModel;

public interface LoteRepository extends JpaRepository<LoteModel, Integer> {

	void save(@Valid EstoqueDto transacao);

}
