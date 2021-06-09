package com.IJeans.Backend.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.IJeans.Backend.exception.NumeroNegativoException;
import com.IJeans.Backend.exception.ProdutoExistenteException;
import com.IJeans.Backend.exception.ProdutoJaCadastradoException;
import com.IJeans.Backend.exception.StandardError;

@RestControllerAdvice
public class ErrorInterceptorHandler {

	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public StandardError handle(HttpRequestMethodNotSupportedException e){
		System.out.println(e.toString());
		StandardError error = new StandardError( 405,e.toString()
				, e.getMessage() );
		
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFound.class)
	public StandardError handle(NotFound e){
		System.out.println(e.toString());
		StandardError error = new StandardError( 404,e.toString()
				, e.getMessage() );
		
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProdutoExistenteException.class)
	public StandardError handle(ProdutoExistenteException e){
		System.out.println(e.toString());
		StandardError error = new StandardError( 404,e.toString()
				, e.getMessage() );
		
		return error;
	}
	
	
	
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProdutoJaCadastradoException.class)
	public StandardError handle(ProdutoJaCadastradoException e){
		StandardError error = new StandardError( 400,""
				, "Produto Ja Cadastrado" );
		
		return error;
	}
	
	
	
	
	
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumeroNegativoException.class)
	public StandardError handle(NumeroNegativoException e){
		System.out.println(e.toString());
		StandardError error = new StandardError( 400,e.toString()
				, e.getMessage() );
		
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequest.class)
	public StandardError handle(BadRequest e){
		System.out.println(e.toString());
		StandardError error = new StandardError( 400,e.toString()
				, e.getMessage() );
		
		return error;
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public StandardError handle(RuntimeException e){
		System.out.println(e.toString());
		StandardError error = new StandardError( 500,e.toString()
				, e.getMessage() );
		return error;
	}
}