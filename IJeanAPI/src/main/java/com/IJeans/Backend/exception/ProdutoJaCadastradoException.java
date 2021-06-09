package com.IJeans.Backend.exception;

public class ProdutoJaCadastradoException extends Exception  {
	
	
	public ProdutoJaCadastradoException(String msg) {
		super(msg);
	}
	
	public ProdutoJaCadastradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
