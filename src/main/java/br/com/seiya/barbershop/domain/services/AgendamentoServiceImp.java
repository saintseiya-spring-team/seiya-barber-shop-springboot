package br.com.seiya.barbershop.domain.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;

import br.com.seiya.barbershop.adapter.data.entities.AgendamentoEntity;
import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.mapper.AgendamentoMapper;
import br.com.seiya.barbershop.domain.dtos.AgendamentoRequest;
import br.com.seiya.barbershop.domain.dtos.AgendamentoResponse;
import br.com.seiya.barbershop.domain.ports.AgendamentoRepositoryPort;
import br.com.seiya.barbershop.domain.ports.AgendamentoServicePort;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ClienteRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ServicoRepositoryPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AgendamentoServiceImp implements AgendamentoServicePort {

	private final AgendamentoRepositoryPort repository;
	private final BarbeiroRepositoryPort barbeiroRepository;
	private final ClienteRepositoryPort clienteRepository;
	private final ServicoRepositoryPort servicoRepository;
	private final AgendamentoMapper map;

	@Override
	public AgendamentoResponse cadastrar(AgendamentoRequest dados) {
		AgendamentoEntity agendamentoEntity = map.toAgendamentoEntity(dados);
		BarbeiroEntity barbeiro = barbeiroRepository.buscarPorId(dados.barbeiroCpf);
		
		
		return map.toAgendamentoResponse(repository.salvar(agendamentoEntity));
	}

	private AgendamentoEntity alocarBarbeiro(AgendamentoRequest dados, AgendamentoEntity agendamentoEntity) {
		agendamentoEntity.setBarbeiro(barbeiroRepository.buscarPorId(dados.barbeiroCpf));
		agendamentoEntity.setCliente(clienteRepository.buscarPorId(dados.clienteCpf));
		agendamentoEntity.setServico(servicoRepository.buscarPorId(dados.servicoId));
		return agendamentoEntity;
	}

	@Override
	public AgendamentoResponse buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AgendamentoResponse> paginar(org.springframework.data.domain.Pageable pagima) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgendamentoResponse atualizar(Long id, @Valid AgendamentoRequest dados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exclusaoLogica(Long id) {
		// TODO Auto-generated method stub
		
	}



}
