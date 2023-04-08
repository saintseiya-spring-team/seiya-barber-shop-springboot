package br.com.seiya.barbershop.domain.services;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.adapter.mapper.ServicoMapper;
import br.com.seiya.barbershop.domain.dtos.ConsultaComplexaRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ServicoRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ServicoServicePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicoServiceImp implements ServicoServicePort {

	private final ServicoRepositoryPort repository;
	private final BarbeiroRepositoryPort barbeiroRepository;
	private final ServicoMapper map;

	@Override
	public ServicoResponse cadastrar(ServicoRequest servico) {
		ServicoEntity servicoEntity = map.toServicoEntity(servico);
		servicoEntity.setBarbeiro(barbeiroRepository.buscarPorId(servico.barbeiroCpf));
		return map.toServicoResponse(repository.salvar(servicoEntity));
	}

	@Override
	public ServicoResponse buscarPorId(Long id) {
		return map.toServicoResponse(repository.buscarPorId(id));
	}

	@Override
	public Page<ServicoResponse> paginar(Pageable pagina) {
		return repository.buscarTodos(pagina).map(map::toServicoResponse);
	}

	@Override
	@Transactional
	public ServicoResponse atualizar(Long id, ServicoRequest dados) {
		ServicoEntity servico = repository.buscarPorId(id);
		servico.setBarbeiro(barbeiroRepository.buscarPorId(dados.barbeiroCpf));
		servico.setDuracaoEmMinutos(dados.duracaoEmMinutos);
		servico.setPreco(dados.preco);
		servico.setTipo(dados.tipo);
		return map.toServicoResponse(servico);
	}

	@Override
	@Transactional
	public void exclusaoLogica(Long id) {
		ServicoEntity servico = repository.buscarPorId(id);
		servico.setStatus(false);
	}

	@Override
	public List<ServicoResponse> buscarPorNomeBarbeiro(String nome) {
		return repository.buscarPorNomeBarbeiro(nome).stream().map(map::toServicoResponse).collect(Collectors.toList());
	}

	@Override
	public List<ServicoResponse> buscarPorTipo(ServicoTipoEnum tipo) {
		return repository.buscarPorTipo(tipo).stream().map(map::toServicoResponse).collect(Collectors.toList());
	}
	
	@Override
	public List<ServicoResponse> buscarPorTipoEDisponbilidade(ConsultaComplexaRequest request) {
		return repository.buscarPorTipoEDisponbilidade(request.tipo, request.diaDaSemana, request.horarioAtendimento)
				.stream()
				.map(map::toServicoResponse)
			    .collect(Collectors.toList());

	}

}
