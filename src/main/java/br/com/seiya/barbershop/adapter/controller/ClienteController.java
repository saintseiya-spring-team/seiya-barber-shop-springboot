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

import br.com.seiya.barbershop.domain.dtos.ClienteRequest;
import br.com.seiya.barbershop.domain.dtos.ClienteResponse;
import br.com.seiya.barbershop.domain.ports.ClienteServicePort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteController {
 
	private final ClienteServicePort service;

	@PostMapping
	public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest dados) {
		var clienteResponse = service.cadastrar(dados);
		return ResponseEntity.created(URI.create("/descricao/" + clienteResponse.cpf)).body(clienteResponse);
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<ClienteResponse> buscar(@PathVariable  String cpf) {
		return ResponseEntity.ok(service.buscarPorId(cpf));
	}

	@GetMapping
	public ResponseEntity<Page<ClienteResponse>> paginar(Pageable pagina) {
		return ResponseEntity.ok(service.paginar(pagina));
	}

	@PutMapping("/{cpf}")
	public ResponseEntity<ClienteResponse> atualizar(@PathVariable String cpf, @RequestBody @Valid ClienteRequest dados) {
		return ResponseEntity.ok(service.atualizar(cpf, dados));
	}

	@DeleteMapping("/{cpf}")
	public ResponseEntity<ClienteResponse> deletar(@PathVariable String cpf) {
		service.exclusaoLogica(cpf);
		return ResponseEntity.noContent().build();
	}
}
