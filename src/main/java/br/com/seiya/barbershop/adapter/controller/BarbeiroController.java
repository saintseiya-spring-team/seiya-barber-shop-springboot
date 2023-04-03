package br.com.seiya.barbershop.adapter.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/barbeiros")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class BarbeiroController {

	private final BarbeiroServicePort service;
	
	
	@PostMapping
	public ResponseEntity<BarbeiroResponse> cadastrarBarbeiro(@RequestBody @Valid BarbeiroRequest dados) {
		var barbeiroResponse = service.cadastrar(dados);
		return ResponseEntity.created(URI.create("/descricao/"+barbeiroResponse.cpf)).body(barbeiroResponse);
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<BarbeiroResponse> buscaBarbeiro(@PathVariable String cpf) {
		return ResponseEntity.ok(service.buscarPorId(cpf));
	}
	
	@GetMapping
	public ResponseEntity<Page<BarbeiroResponse>> paginarBarbeiro(Pageable pagina) {
		return ResponseEntity.ok(service.paginarBarbeiros(pagina));
	}
	
	@PutMapping("/{cpf}")
	public ResponseEntity<BarbeiroResponse> atualizarBarbeiro(@PathVariable String cpf, @RequestBody @Valid BarbeiroRequest dados) {
		return ResponseEntity.ok(service.atualizarBarbeiro(cpf, dados));
	}
	
	@DeleteMapping("/{cpf}")
	public ResponseEntity<BarbeiroResponse> deletarBarbeiro(@PathVariable String cpf) {
		service.exclusaoLogicaBarbeiro(cpf);
		return ResponseEntity.noContent().build();
	}
}
