package br.com.seiya.barbershop.domain.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.mapper.BarbeiroMapper;
import br.com.seiya.barbershop.domain.dtos.Barbeiro;
import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import lombok.RequiredArgsConstructor;

//TODO fazer injeção de dependencia apenas por construtor
@RequiredArgsConstructor
public class BarbeiroServiceImp implements BarbeiroServicePort {

	private final BarbeiroRepositoryPort repository;
	private final BarbeiroMapper map;

	@Override
	public BarbeiroResponse cadastrar(BarbeiroRequest barbeiro) {
		BarbeiroEntity entidade = repository.salvar(map.toBarbeiroEntity(barbeiro));
		return map.toBarbeiroResponse(entidade);
	}

	@Override
	public BarbeiroResponse buscarPorId(Long id) {
		return map.toBarbeiroResponse(repository.buscarPorId(id));
	}

	@Override
	public Page<BarbeiroResponse> paginarBarbeiros(Pageable pagima) {
		return repository.buscarTodos(pagima).map(map::toBarbeiroResponse);
	}

	@Override
	@Transactional
	public BarbeiroResponse atualizarBarbeiro(Long id, Barbeiro dados) {
		BarbeiroEntity barbeiro = repository.buscarPorId(id);
		barbeiro.setNome(dados.nome);
		barbeiro.setEmail(dados.email);
		barbeiro.setTelefone(dados.telefone);
		return map.toBarbeiroResponse(barbeiro);
	}

	@Override
	@Transactional
	public void exclusaoLogicaBarbeiro(Long id) {
		BarbeiroEntity barbeiro = repository.buscarPorId(id);
		barbeiro.setAtivo(false);
	}

}
