package br.com.seiya.barbershop.dominio.adaptadores.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.dominio.portas.interfaces.BarbeiroServicePort;
import br.com.seiya.barbershop.dominio.portas.repositories.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public class BarbeiroServiceImp implements BarbeiroServicePort {

	@Autowired
	private BarbeiroRepositoryPort repository;

	public BarbeiroServiceImp(BarbeiroRepositoryPort repository) {
		this.repository = repository;
	}

	@Override
	public Barbeiro cadastrar(BarbeiroDTO barbeiro) {
		return repository.salvar(barbeiro);

	}

	@Override
	public Barbeiro buscarPorId(Long id) {
		return repository.buscarPorId(id);
	}

	@Override
	public Page<BarbeiroResponseDTO> paginarBarbeiros(Pageable pagima) {
		return repository.buscarTodos(pagima).map(BarbeiroResponseDTO::new);
	}

}
