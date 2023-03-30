package br.com.seiya.barbershop.aplicativo.adaptadores.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroCadastroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.dominio.portas.interfaces.BarbeiroServicePort;

@RestController
@CrossOrigin(origins = "*")
public class BarbeiroController {

	@Autowired
	private BarbeiroServicePort service;
	
	
	@PostMapping("/barbeiros")
	public ResponseEntity<BarbeiroResponseDTO> cadastrarBarbeiro(@RequestBody @Valid BarbeiroCadastroDTO dados) {
		var barbeiro = service.cadastrar(dados);
		return ResponseEntity.created(URI.create("/descricao/"+barbeiro.getId())).body(new BarbeiroResponseDTO(barbeiro));
	}
	
	@GetMapping("/barbeiros/{id}")
	public ResponseEntity<BarbeiroResponseDTO> buscaBarbeiro(@PathVariable Long id) {
		return ResponseEntity.ok(service.buscarPorId(id));
	}
	
	@GetMapping("/barbeiros")
	public ResponseEntity<Page<BarbeiroResponseDTO>> paginaBarbeiro(Pageable pagina) {
		return ResponseEntity.ok(service.paginarBarbeiros(pagina));
	}
	
	@PutMapping("/barbeiros/{id}")
	public ResponseEntity<BarbeiroResponseDTO> atualizarBarbeiro(@PathVariable Long id, @RequestBody @Valid BarbeiroDTO dados) {
		return ResponseEntity.ok(service.atualizarBarbeiro(id, dados));
	}
	
	@DeleteMapping("/barbeiros/{id}")
	public ResponseEntity<BarbeiroResponseDTO> detelarBarbeiro(@PathVariable Long id) {
		service.exclusaoLogicaBarbeiro(id);
		return ResponseEntity.noContent().build();
	}
}
