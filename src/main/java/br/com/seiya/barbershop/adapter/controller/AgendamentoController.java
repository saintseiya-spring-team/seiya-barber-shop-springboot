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

import br.com.seiya.barbershop.domain.dtos.AgendamentoRequest;
import br.com.seiya.barbershop.domain.dtos.AgendamentoResponse;
import br.com.seiya.barbershop.domain.ports.AgendamentoServicePort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AgendamentoController {
 
	private final AgendamentoServicePort service;

	@PostMapping
	public ResponseEntity<AgendamentoResponse> cadastrar(@RequestBody @Valid AgendamentoRequest dados) {
		var agendamentoResponse = service.cadastrar(dados);
		return ResponseEntity.created(URI.create("/descricao/" + agendamentoResponse.id)).body(agendamentoResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AgendamentoResponse> buscar(@PathVariable  Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<Page<AgendamentoResponse>> paginar(Pageable pagina) {
		return ResponseEntity.ok(service.paginar(pagina));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AgendamentoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AgendamentoRequest dados) {
		return ResponseEntity.ok(service.atualizar(id, dados));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<AgendamentoResponse> deletar(@PathVariable Long id) {
		service.exclusaoLogica(id);
		return ResponseEntity.noContent().build();
	}
}
