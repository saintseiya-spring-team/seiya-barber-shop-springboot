package br.com.seiya.barbershop.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
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
import br.com.seiya.barbershop.util.BarbeiroEntityCreator;
import br.com.seiya.barbershop.util.BarbeiroRequestCreator;
import br.com.seiya.barbershop.util.BarbeiroResponseCreator;

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
	@DisplayName("Cadastrar barbeiro com sucesso.")
	void cadastrarBarbeiroComSucesso() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		
		when(repository.salvar(ArgumentMatchers.any())).thenReturn(entity);
		when(map.toBarbeiroResponse(entity)).thenReturn(response);
		
		//acao
		BarbeiroResponse retorno = service.cadastrar(BarbeiroRequestCreator.paraSalvar());

	    // verificação
	    assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	@DisplayName("Buscar barbeiro com sucesso.")
	void buscarBarbeiroComSucesso() {
		// cenario
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(ArgumentMatchers.anyString())).thenReturn(entity);
		when(map.toBarbeiroResponse(entity)).thenReturn(response);
		
		//acao
		BarbeiroResponse retorno = service.buscarPorId(BarbeiroEntityCreator.paraSalvar().getCpf());
		
		// verificação
		assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	@DisplayName("Paginar barbeiro com sucesso.")
	void paginarBarbeiroComSucesso() {
		// cenario
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarTodos(ArgumentMatchers.any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(entity)));
		when(map.toBarbeiroResponse(entity)).thenReturn(response);
		
		//acao
		Page<BarbeiroResponse> retorno = service.paginarBarbeiros(PageRequest.of(1, 1));
		
		// verificação
		assertThat(retorno)
				.isNotNull()
				.isNotEmpty()
				.hasSize(1);
		
		assertThat(retorno.toList().get(0)).isEqualTo(response);
	}
	
	@Test
	@DisplayName("Atualizar barbeiro com sucesso.")
	void atualizarBarbeiroComSucesso() {
		// cenario
		BarbeiroRequest request = BarbeiroRequestCreator.paraAtualizar();
		BarbeiroResponse response = BarbeiroResponseCreator.paraAtualizar();
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(ArgumentMatchers.anyString())).thenReturn(entity);
		when(map.toBarbeiroResponse(BarbeiroEntityCreator.paraAtualizar())).thenReturn(response);
		
		//acao
		BarbeiroResponse retorno = service.atualizarBarbeiro(entity.getCpf(), request);
		
		// verificação
		assertThat(retorno).isEqualTo(response);
		
		assertThat(entity.getCpf()).isEqualTo(request.cpf);
		
		assertThat(entity.getNome()).isEqualTo(request.nome);
		
		assertThat(entity.getEmail()).isEqualTo(request.email);
		
		assertThat(entity.getTelefone()).isEqualTo(request.telefone);
		
	}
	
	@Test
	@DisplayName("Deletar barbeiro com sucesso.")
	void deletarBarbeiroComSucesso() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(ArgumentMatchers.anyString())).thenReturn(entity);
		
		//acao
		service.exclusaoLogicaBarbeiro(BarbeiroRequestCreator.paraSalvar().cpf);

	    // verificação
	    assertThat(entity.getAtivo()).isFalse();
	}

}
