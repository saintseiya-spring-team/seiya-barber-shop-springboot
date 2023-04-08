package br.com.seiya.barbershop.adapter.controller;

import java.net.URI;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;

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

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.domain.dtos.ConsultaComplexaRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.domain.ports.ServicoServicePort;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/servicos")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ServicoController {
 
	private final ServicoServicePort service;

	@PostMapping
	public ResponseEntity<ServicoResponse> cadastrar(@RequestBody @Valid ServicoRequest dados) {
		var servicoResponse = service.cadastrar(dados);
		return ResponseEntity.created(URI.create("/descricao/" + servicoResponse.tipo)).body(servicoResponse);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ServicoResponse> buscar(@PathVariable  Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping("barbeiro/{nome}")
	public ResponseEntity<List<ServicoResponse>> buscarPorBarbeiro(@PathVariable  String nome) {
		return ResponseEntity.ok(service.buscarPorNomeBarbeiro(nome));
	}
	
	@GetMapping("tipo/{tipo}")
	public ResponseEntity<List<ServicoResponse>> buscarPorTipo(@PathVariable  ServicoTipoEnum tipo) {
		return ResponseEntity.ok(service.buscarPorTipo(tipo));
	}
	@GetMapping("/complexo")
	public ResponseEntity<List<ServicoResponse>> buscarPorTipoEDisponbilidade(@RequestBody ConsultaComplexaRequest request) {
		return ResponseEntity.ok(service.buscarPorTipoEDisponbilidade(request));
	}

	@GetMapping
	public ResponseEntity<Page<ServicoResponse>> paginar(Pageable pagina) {
		return ResponseEntity.ok(service.paginar(pagina));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ServicoResponse> atualizar(@PathVariable Long id, @RequestBody @Valid ServicoRequest dados) {
		return ResponseEntity.ok(service.atualizar(id, dados));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ServicoResponse> deletar(@PathVariable Long id) {
		service.exclusaoLogica(id);
		return ResponseEntity.noContent().build();
	}
}
