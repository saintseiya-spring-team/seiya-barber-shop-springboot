package br.com.seiya.barbershop.aplicativo.adaptadores.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.dominio.portas.interfaces.BarbeiroServicePort;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;


public class BarbeiroController {

	
	private BarbeiroServicePort service;
	
	@PostMapping("/barbeiros")
	public void cadastrarBarbeiro(@RequestBody BarbeiroDTO dados) {
//		Barbeiro barbeiro = service.cadastrar(dados);
//		return ResponseEntity.created(URI.create(barbeiro.getId().toString())).body(new BarbeiroResponseDTO());
	}
}
