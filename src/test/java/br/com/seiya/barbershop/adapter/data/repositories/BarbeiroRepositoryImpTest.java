package br.com.seiya.barbershop.adapter.data.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
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

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;
@ExtendWith(MockitoExtension.class)
@DisplayName("Testes para BarbeiroRepositoryImpTest.")
class BarbeiroRepositoryImpTest {
	
	@InjectMocks
	BarbeiroRepositoryImp repository;
	
	@Mock
	private BarbeiroJpaRepository springRepository;

	@Test
	void salvarBarbeiroComSucesso() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyString())).thenReturn(Optional.empty());
		when(springRepository.save(any(BarbeiroEntity.class))).thenReturn(entity);
		
		BarbeiroEntity retorno = repository.salvar(entity);

	    assertThat(retorno).isEqualTo(entity);
	}
	
	@Test
	void salvarBarbeiroSemSucessoIdJaCadastrado() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyString())).thenReturn(Optional.of(entity));
		
		assertThrows(IdJaCadastradoException.class, () -> repository.salvar(entity));
		
	}
	
	@Test
	void buscarBarbeiroComSucesso() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyString())).thenReturn(Optional.of(entity));
		
		BarbeiroEntity retorno = repository.buscarPorId(entity.getCpf());

	    assertThat(retorno).isEqualTo(entity);
	}
	
	@Test
	void buscarBarbeiroSemSucessoIdNaoEncontrado() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(anyString())).thenReturn(Optional.empty());
		
		assertThrows(IdNaoEncontradoException.class, () -> repository.buscarPorId(entity.getCpf()));
	}
	
	@Test
	void paginarTodosBarbeirosComSucesso() {
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		PageRequest pagina = PageRequest.of(0, 10);
		
		when(springRepository.findAllQuandoEstaAtivo(pagina)).thenReturn(new PageImpl<>(List.of(entity)));
		
		Page<BarbeiroEntity> retorno = repository.buscarTodos(pagina);

	    assertThat(retorno)
	    .isNotNull()
	    .isNotEmpty()
	    .hasSize(1);
	    
	    assertThat(retorno.toList().get(0)).isEqualTo(entity);
	}

}
