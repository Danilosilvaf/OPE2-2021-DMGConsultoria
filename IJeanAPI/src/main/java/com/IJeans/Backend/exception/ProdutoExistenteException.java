package com.IJeans.Backend.exception;

public class ProdutoExistenteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProdutoExistenteException(String msg) {
		super(msg);
	}
	
	public ProdutoExistenteException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
