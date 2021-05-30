package com.IJeans.Backend.service;

import javax.validation.Valid;

import com.IJeans.Backend.controller.dto.EstoqueDto;

public interface EstoqueService {

	void registrarTransacao(@Valid EstoqueDto transacao);

}
