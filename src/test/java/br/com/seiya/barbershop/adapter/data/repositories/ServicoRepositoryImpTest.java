package br.com.seiya.barbershop.adapter.data.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

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
import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.ServicoNaoCadastradoException;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;
import br.com.seiya.barbershop.util.Servico.ServicoEntityCreator;
import br.com.seiya.barbershop.util.Servico.ServicoRequestCreator;
@ExtendWith(MockitoExtension.class)
@DisplayName("Testes para ServicoRepositoryImpTest.")
class ServicoRepositoryImpTest {
	
	@InjectMocks
	ServicoRepositoryImp repository;
	
	@Mock
	private ServicoJpaRepository springRepository;

	@Test
	void salvarServicoComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyLong())).thenReturn(Optional.empty());
		when(springRepository.save(any(ServicoEntity.class))).thenReturn(entity);
		
		ServicoEntity retorno = repository.salvar(entity);

	    assertThat(retorno).isEqualTo(entity);
	}
	
	@Test
	void salvarServicoSemSucessoIdJaCadastrado() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyLong())).thenReturn(Optional.of(entity));
		
		assertThrows(IdJaCadastradoException.class, () -> repository.salvar(entity));
		
	}
	
	@Test
	void buscarServicoComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyLong())).thenReturn(Optional.of(entity));
		
		ServicoEntity retorno = repository.buscarPorId(entity.getId());

	    assertThat(retorno).isEqualTo(entity);
	}
	
	@Test
	void buscarPorNomeBarbeiroComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByNomeBarbeiroQuandoEstativo(anyString())).thenReturn(List.of(entity));
		
		List<ServicoEntity> retorno = repository.buscarPorNomeBarbeiro(BarbeiroEntityCreator.paraSalvar().getNome());
		
		assertThat(retorno).contains(entity);
	}
	
	@Test
	void buscarPorNomeBarbeiroSemSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByNomeBarbeiroQuandoEstativo(anyString())).thenReturn(List.of());
		
		assertThrows(ServicoNaoCadastradoException.class, () -> repository.buscarPorNomeBarbeiro(entity.getBarbeiro().getNome()));
	}
	
	@Test
	void buscarPorTipoComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByTipoQuandoEstativo(any(ServicoTipoEnum.class))).thenReturn(List.of(entity));
		
		List<ServicoEntity> retorno = repository.buscarPorTipo(ServicoRequestCreator.paraSalvar().tipo);
		
		assertThat(retorno).contains(entity);
	}
	
	@Test
	void buscarPorTipoSemSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByTipoQuandoEstativo(any(ServicoTipoEnum.class))).thenReturn(List.of());
		
		assertThrows(ServicoNaoCadastradoException.class, () -> repository.buscarPorTipo(entity.getTipo()));
	}
	
	@Test
	void buscarServicoSemSucessoIdNaoEncontrado() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyLong())).thenReturn(Optional.empty());
		
		assertThrows(IdNaoEncontradoException.class, () -> repository.buscarPorId(entity.getId()));
	}
	
	@Test
	void paginarTodosServicosComSucesso() {
		ServicoEntity entity = ServicoEntityCreator.paraSalvar();
		PageRequest pagina = PageRequest.of(0, 10);
		
		when(springRepository.findAllQuandoEstaAtivo(pagina)).thenReturn(new PageImpl<>(List.of(entity)));
		
		Page<ServicoEntity> retorno = repository.buscarTodos(pagina);

	    assertThat(retorno)
	    .isNotNull()
	    .isNotEmpty()
	    .hasSize(1);
	    
	    assertThat(retorno.toList().get(0)).isEqualTo(entity);
	}

}
