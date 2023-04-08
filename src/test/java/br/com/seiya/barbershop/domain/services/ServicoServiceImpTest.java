package br.com.seiya.barbershop.domain.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.adapter.mapper.ServicoMapper;
import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ServicoRepositoryPort;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;
import br.com.seiya.barbershop.util.Servico.ServicoEntityCreator;
import br.com.seiya.barbershop.util.Servico.ServicoRequestCreator;
import br.com.seiya.barbershop.util.Servico.ServicoResponseCreator;

@ExtendWith(value = MockitoExtension.class)
@DisplayName("Testes para ServicoServiceImp.")
class ServicoServiceImpTest {

	@InjectMocks
	private ServicoServiceImp service;
	
	@Mock
	private ServicoRepositoryPort repository;
	
	@Mock
	private BarbeiroRepositoryPort barbeiroRepository;
	
	@Mock
	private ServicoMapper map;
	
	@Test
	void cadastrarServicoComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		
		when(map.toServicoEntity(any(ServicoRequest.class))).thenReturn(entity);
		when(barbeiroRepository.buscarPorId(anyString())).thenReturn(BarbeiroEntityCreator.paraSalvar());
		when(repository.salvar(any(ServicoEntity.class))).thenReturn(entity);
		when(map.toServicoResponse(any(ServicoEntity.class))).thenReturn(response);
		
		ServicoResponse retorno = service.cadastrar(ServicoRequestCreator.paraSalvar());

	    assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	void buscarServicoComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyLong())).thenReturn(entity);
		when(map.toServicoResponse(any(ServicoEntity.class))).thenReturn(response);
		
		ServicoResponse retorno = service.buscarPorId(ServicoEntityCreator.paraSalvar().getId());
		
		assertThat(retorno).isEqualTo(response);
	}
	
	@Test
	void buscarPorNomeBarbeiroComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(repository.buscarPorNomeBarbeiro(anyString())).thenReturn(List.of(entity));
		when(map.toServicoResponse(any(ServicoEntity.class))).thenReturn(response);
		
		List<ServicoResponse> retorno = service.buscarPorNomeBarbeiro(BarbeiroEntityCreator.paraSalvar().getNome());
		
		assertThat(retorno).contains(response);
	}
	
	@Test
	void buscarPorTipoComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(repository.buscarPorTipo(any(ServicoTipoEnum.class))).thenReturn(List.of(entity));
		when(map.toServicoResponse(any(ServicoEntity.class))).thenReturn(response);
		
		List<ServicoResponse> retorno = service.buscarPorTipo(ServicoRequestCreator.paraSalvar().tipo);
		
		assertThat(retorno).contains(response);
	}
	
	@Test
	void paginarServicoComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(repository.buscarTodos(any(PageRequest.class))).thenReturn(new PageImpl<>(List.of(entity)));
		when(map.toServicoResponse(entity)).thenReturn(response);
		
		Page<ServicoResponse> retorno = service.paginar(PageRequest.of(1, 1));
		
		assertThat(retorno)
				.isNotNull()
				.isNotEmpty()
				.hasSize(1);
		
		assertThat(retorno.toList().get(0)).isEqualTo(response);
	}
	
	@Test
	@DisplayName("Atualizar Servico com sucesso.")
	void atualizarServicoComSucesso() {
		ServicoRequest request = ServicoRequestCreator.paraAtualizar();
		ServicoResponse response = ServicoResponseCreator.paraAtualizar();
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyLong())).thenReturn(entity);
		when(barbeiroRepository.buscarPorId(anyString())).thenReturn(BarbeiroEntityCreator.paraSalvar());
		when(map.toServicoResponse(any(ServicoEntity.class))).thenReturn(response);
		
		ServicoResponse retorno = service.atualizar(entity.getId(), request);
		
		assertThat(retorno).isEqualTo(response);
		
		assertThat(entity.getBarbeiro().getCpf()).isEqualTo(request.barbeiroCpf);
		
		assertThat(entity.getDuracaoEmMinutos()).isEqualTo(request.duracaoEmMinutos);
		
		assertThat(entity.getPreco()).isEqualTo(request.preco);
		
		assertThat(entity.getTipo()).isEqualTo(request.tipo);
		
	}
	
	@Test
	void deletarServicoComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(repository.buscarPorId(anyLong())).thenReturn(entity);
		
		service.exclusaoLogica(1l);

	    assertThat(entity.getStatus()).isFalse();
	}

}
