package br.com.seiya.barbershop.domain.services;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.mapper.BarbeiroMapper;
import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import lombok.RequiredArgsConstructor;

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
	public BarbeiroResponse buscarPorId(String cpf) {
		return map.toBarbeiroResponse(repository.buscarPorId(cpf));
	}

	@Override
	public Page<BarbeiroResponse> paginarBarbeiros(Pageable pagina) {
		return repository.buscarTodos(pagina).map(map::toBarbeiroResponse);
	}

	@Override
	@Transactional
	public BarbeiroResponse atualizarBarbeiro(String cpf, BarbeiroRequest dados) {
		BarbeiroEntity barbeiro = repository.buscarPorId(cpf);
		barbeiro.setNome(dados.nome);
		barbeiro.setEmail(dados.email);
		barbeiro.setTelefone(dados.telefone);
		return map.toBarbeiroResponse(barbeiro);
	}

	@Override
	@Transactional
	public void exclusaoLogicaBarbeiro(String cpf) {
		BarbeiroEntity barbeiro = repository.buscarPorId(cpf);
		barbeiro.setAtivo(false);
	}

}
