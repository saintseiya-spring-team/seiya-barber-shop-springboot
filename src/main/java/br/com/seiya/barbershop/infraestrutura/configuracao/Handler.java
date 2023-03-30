package br.com.seiya.barbershop.infraestrutura.configuracao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.seiya.barbershop.dominio.exceptions.IdNaoEncontrado;

@RestControllerAdvice
public class Handler {

	@ExceptionHandler(IdNaoEncontrado.class)
	public ResponseEntity<Object> idNaoEncontrado(Exception e) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<String> campos = new ArrayList<>();
		e.getFieldErrors().stream().forEach(er -> campos.add(er.getField()));
		return ResponseEntity.badRequest().body("Os seguintes campos não são válidos:\n" + campos + "\n");
	}

}
