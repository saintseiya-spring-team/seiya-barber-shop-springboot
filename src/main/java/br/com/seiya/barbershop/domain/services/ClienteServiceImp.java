package br.com.seiya.barbershop.domain.services;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;
import br.com.seiya.barbershop.adapter.mapper.ClienteMapper;
import br.com.seiya.barbershop.domain.dtos.ClienteRequest;
import br.com.seiya.barbershop.domain.dtos.ClienteResponse;
import br.com.seiya.barbershop.domain.ports.ClienteRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ClienteServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteServiceImp implements ClienteServicePort {

	private final ClienteRepositoryPort repository;
	private final ClienteMapper map;

	@Override
	public ClienteResponse cadastrar(ClienteRequest cliente) {
		return map.toClienteResponse(repository.salvar(map.toClienteEntity(cliente)));
	}

	@Override
	public ClienteResponse buscarPorId(String cpf) {
		return map.toClienteResponse(repository.buscarPorId(cpf));
	}

	@Override
	public Page<ClienteResponse> paginar(Pageable pagina) {
		return repository.buscarTodos(pagina).map(map::toClienteResponse);
	}

	@Override
	@Transactional
	public ClienteResponse atualizar(String cpf, ClienteRequest dados) {
		ClienteEntity cliente = repository.buscarPorId(cpf);
		cliente.setNome(dados.nome);
		cliente.setEmail(dados.email);
		cliente.setTelefone(dados.telefone);
		return map.toClienteResponse(cliente);
	}

	@Override
	@Transactional
	public void exclusaoLogica(String cpf) {
		ClienteEntity cliente = repository.buscarPorId(cpf);
		cliente.setStatus(false);
	}

}
