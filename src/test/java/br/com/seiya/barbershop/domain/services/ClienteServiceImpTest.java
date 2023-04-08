package br.com.seiya.barbershop.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;
import br.com.seiya.barbershop.adapter.mapper.ClienteMapper;
import br.com.seiya.barbershop.domain.dtos.ClienteRequest;
import br.com.seiya.barbershop.domain.dtos.ClienteResponse;
import br.com.seiya.barbershop.domain.ports.ClienteRepositoryPort;
import br.com.seiya.barbershop.util.Cliente.ClienteEntityCreator;
import br.com.seiya.barbershop.util.Cliente.ClienteRequestCreator;
import br.com.seiya.barbershop.util.Cliente.ClienteResponseCreator;

@ExtendWith(value = MockitoExtension.class)
@DisplayName("Testes para ClienteServiceImp.")
class ClienteServiceImpTest {

	@InjectMocks
	private ClienteServiceImp service;
	
	@Mock
	private ClienteRepositoryPort repository;
	
	@Mock
	private ClienteMapper map;
	
	@Test
	void cadastrarClienteComSucesso() {
		ClienteEntity entity = ClienteEntityCreator.paraSalvar();
		ClienteResponse response = ClienteResponseCreator.paraSalvar();
		
		when(repository.salvar(any())).thenReturn(entity);
		when(map.toClienteResponse(entity)).thenReturn(response);
		
		ClienteResponse retorno = service.cadastrar(ClienteRequestCreator.paraSalvar());

	    assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	void buscarClienteComSucesso() {
		ClienteResponse response = ClienteResponseCreator.paraSalvar();
		ClienteEntity entity = ClienteEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyString())).thenReturn(entity);
		when(map.toClienteResponse(entity)).thenReturn(response);
		
		ClienteResponse retorno = service.buscarPorId(ClienteEntityCreator.paraSalvar().getCpf());
		
		assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	void paginarClienteComSucesso() {
		ClienteResponse response = ClienteResponseCreator.paraSalvar();
		ClienteEntity entity = ClienteEntityCreator.paraSalvar();
		
		when(repository.buscarTodos(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(entity)));
		when(map.toClienteResponse(entity)).thenReturn(response);
		
		Page<ClienteResponse> retorno = service.paginar(PageRequest.of(1, 1));
		
		assertThat(retorno)
				.isNotNull()
				.isNotEmpty()
				.hasSize(1);
		
		assertThat(retorno.toList().get(0)).isEqualTo(response);
	}
	
	@Test
	@DisplayName("Atualizar Cliente com sucesso.")
	void atualizarClienteComSucesso() {
		ClienteRequest request = ClienteRequestCreator.paraAtualizar();
		ClienteResponse response = ClienteResponseCreator.paraAtualizar();
		ClienteEntity entity = ClienteEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyString())).thenReturn(entity);
		when(map.toClienteResponse(ClienteEntityCreator.paraAtualizar())).thenReturn(response);
		
		ClienteResponse retorno = service.atualizar(entity.getCpf(), request);
		
		assertThat(retorno).isEqualTo(response);
		
		assertThat(entity.getCpf()).isEqualTo(request.cpf);
		
		assertThat(entity.getNome()).isEqualTo(request.nome);
		
		assertThat(entity.getEmail()).isEqualTo(request.email);
		
		assertThat(entity.getTelefone()).isEqualTo(request.telefone);
		
	}
	
	@Test
	void deletarClienteComSucesso() {
		ClienteEntity entity = ClienteEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyString())).thenReturn(entity);
		
		service.exclusaoLogica(ClienteRequestCreator.paraSalvar().cpf);

	    assertThat(entity.getStatus()).isFalse();
	}

}
