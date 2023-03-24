package br.com.seiya.barbershop.aplicativo.adaptadores.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.dominio.portas.interfaces.BarbeiroServicePort;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

@RestController
public class BarbeiroController {

	@Autowired
	private BarbeiroServicePort service;
	
	@PostMapping("/barbeiros")
	public ResponseEntity<Object> cadastrarBarbeiro(@RequestBody @Valid BarbeiroDTO dados) {
		var barbeiro = service.cadastrar(dados);
		return ResponseEntity.created(URI.create("/descricao/"+barbeiro.getId())).body(new BarbeiroResponseDTO(barbeiro));
	}
	
	@GetMapping("/barbeiros/{id}")
	public ResponseEntity<Barbeiro> buscaBarbeiro(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping("/barbeiros")
	public ResponseEntity<Page<BarbeiroResponseDTO>> paginaBarbeiro(Pageable pagima) {
		return ResponseEntity.ok(service.paginarBarbeiros(pagima));
	}
}
