package br.com.seiya.barbershop.dominio.adaptadores.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroCadastroDTO;
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
	public Barbeiro cadastrar(BarbeiroCadastroDTO barbeiro) {
		return repository.salvar(barbeiro);

	}

	@Override
	public BarbeiroResponseDTO buscarPorId(Long id) {
		return new BarbeiroResponseDTO(repository.buscarPorId(id));
	}

	@Override
	public Page<BarbeiroResponseDTO> paginarBarbeiros(Pageable pagima) {
		return repository.buscarTodos(pagima).map(BarbeiroResponseDTO::new);
	}

	@Override
	@Transactional
	public BarbeiroResponseDTO atualizarBarbeiro(Long id, BarbeiroDTO dados) {
		Barbeiro barbeiro = repository.buscarPorId(id);
		barbeiro.setNome(dados.nome);
		barbeiro.setEmail(dados.email);
		barbeiro.setTelefone(dados.telefone);
		return new BarbeiroResponseDTO(barbeiro);
	}

	@Override
	@Transactional
	public void exclusaoLogicaBarbeiro(Long id) {
		Barbeiro barbeiro = repository.buscarPorId(id);
		barbeiro.setAtivo(false);
	}

}
