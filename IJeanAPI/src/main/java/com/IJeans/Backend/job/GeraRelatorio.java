package com.IJeans.Backend.job;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IJeans.Backend.controller.dto.RelatorioDTO;
import com.IJeans.Backend.service.RelatorioService;
import com.opencsv.CSVWriter;

@Service
public class GeraRelatorio {
	
	public final String CSV_PATH = "/home/ubuntu/arquivo/relatorio.csv";
	
	
	@Autowired
	private RelatorioService service;
	
	
	public void criaArquivo() {
	         
	        try {
	        	List<RelatorioDTO> relatorios = new ArrayList<RelatorioDTO>();
	            System.out.println("Iniciando geração do CSV");
	             
	            FileWriter fw = new FileWriter(new File(CSV_PATH));
	            CSVWriter cw = new CSVWriter(fw);
	            String[] headers = {"Nome Produto" , "Tipo de Transacao", "Valor por unidade","Quantidade","Data"};
		        
		        
		        List<Object[]> objs = service.findAllRelatorio();

	            List<String[]> data = new ArrayList<String[]>();
	            
	            data.add(headers);
		        
		        for(Object[] obj:objs) {
		        	relatorios.add(new RelatorioDTO(obj));
		        }
		        for(RelatorioDTO relatorio:relatorios) {
		        	data.add(relatorio.Imprimir());
		        }
		        cw.writeAll(data);
		        cw.flush();
		        cw.close();
	            fw.close();
	             
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	       
	        
	        
	        
	}
	        
}
