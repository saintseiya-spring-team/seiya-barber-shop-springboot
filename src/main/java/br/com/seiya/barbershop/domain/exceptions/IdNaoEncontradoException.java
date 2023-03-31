package br.com.seiya.barbershop.domain.exceptions;
//TODO pode ter exceptions em todas as camadas, pode-se portanto categorizar as exceções de acordo com onde elas se manifestarem
public class IdNaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public IdNaoEncontradoException() {
		super();
	}
	
	

}
