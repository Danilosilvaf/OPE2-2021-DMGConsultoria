package com.IJeans.Backend.service;

import java.util.List;

import com.IJeans.Backend.model.TamanhoModel;

public interface TamanhoService {

	List<TamanhoModel> findAll();

	List<TamanhoModel> findByIdTipo(String id);

}
