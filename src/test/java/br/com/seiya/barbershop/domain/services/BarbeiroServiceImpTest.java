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

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.mapper.BarbeiroMapper;
import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroRequestCreator;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroResponseCreator;

@ExtendWith(value = MockitoExtension.class)
@DisplayName("Testes para BarbeiroServiceImp.")
class BarbeiroServiceImpTest {

	@InjectMocks
	private BarbeiroServiceImp service;
	
	@Mock
	private BarbeiroRepositoryPort repository;
	
	@Mock
	private BarbeiroMapper map;
	
	@Test
	void cadastrarBarbeiroComSucesso() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		
		when(repository.salvar(any())).thenReturn(entity);
		when(map.toBarbeiroResponse(entity)).thenReturn(response);
		
		BarbeiroResponse retorno = service.cadastrar(BarbeiroRequestCreator.paraSalvar());

	    assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	void buscarBarbeiroComSucesso() {
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyString())).thenReturn(entity);
		when(map.toBarbeiroResponse(entity)).thenReturn(response);
		
		BarbeiroResponse retorno = service.buscarPorId(BarbeiroEntityCreator.paraSalvar().getCpf());
		
		assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	void paginarBarbeiroComSucesso() {
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarTodos(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(entity)));
		when(map.toBarbeiroResponse(entity)).thenReturn(response);
		
		Page<BarbeiroResponse> retorno = service.paginar(PageRequest.of(1, 1));
		
		assertThat(retorno)
				.isNotNull()
				.isNotEmpty()
				.hasSize(1);
		
		assertThat(retorno.toList().get(0)).isEqualTo(response);
	}
	
	@Test
	@DisplayName("Atualizar barbeiro com sucesso.")
	void atualizarBarbeiroComSucesso() {
		BarbeiroRequest request = BarbeiroRequestCreator.paraAtualizar();
		BarbeiroResponse response = BarbeiroResponseCreator.paraAtualizar();
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyString())).thenReturn(entity);
		when(map.toBarbeiroResponse(BarbeiroEntityCreator.paraAtualizar())).thenReturn(response);
		
		BarbeiroResponse retorno = service.atualizar(entity.getCpf(), request);
		
		assertThat(retorno).isEqualTo(response);
		
		assertThat(entity.getCpf()).isEqualTo(request.cpf);
		
		assertThat(entity.getNome()).isEqualTo(request.nome);
		
		assertThat(entity.getEmail()).isEqualTo(request.email);
		
		assertThat(entity.getTelefone()).isEqualTo(request.telefone);
		
	}
	
	@Test
	void deletarBarbeiroComSucesso() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyString())).thenReturn(entity);
		
		service.exclusaoLogica(BarbeiroRequestCreator.paraSalvar().cpf);

	    assertThat(entity.getAtivo()).isFalse();
	}

}
