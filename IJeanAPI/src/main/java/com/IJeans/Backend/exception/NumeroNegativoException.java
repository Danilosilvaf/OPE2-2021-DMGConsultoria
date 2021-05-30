package com.IJeans.Backend.exception;

public class NumeroNegativoException extends Exception {
	private static final long serialVersionUID = 1L;

	public NumeroNegativoException(String msg) {
		super(msg);
	}
	
	public NumeroNegativoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
