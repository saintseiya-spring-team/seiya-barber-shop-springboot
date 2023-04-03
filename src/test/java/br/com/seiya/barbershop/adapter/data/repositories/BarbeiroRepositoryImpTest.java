package br.com.seiya.barbershop.adapter.data.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

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
import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.util.BarbeiroEntityCreator;
@ExtendWith(MockitoExtension.class)
@DisplayName("Testes para BarbeiroRepositoryImpTest.")
class BarbeiroRepositoryImpTest {
	
	@InjectMocks
	BarbeiroRepositoryImp repository;
	
	@Mock
	private BarbeiroJpaRepository springRepository;

	@Test
	@DisplayName("Salvar barbeiro com sucesso.")
	void salvarBarbeiroComSucesso() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
		when(springRepository.save(ArgumentMatchers.any(BarbeiroEntity.class))).thenReturn(entity);
		
		//acao
		BarbeiroEntity retorno = repository.salvar(entity);

	    // verificação
	    assertThat(retorno).isEqualTo(entity);
	}
	
	@Test
	@DisplayName("Salvar barbeiro sem sucesso, id já cadastrado.")
	void salvarBarbeiroSemSucessoIdJaCadastrado() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(ArgumentMatchers.anyString())).thenReturn(Optional.of(entity));
		
		//acao e verificação
		assertThrows(IdJaCadastradoException.class, () -> repository.salvar(entity));
		
	}
	
	@Test
	@DisplayName("Buscar barbeiro com sucesso.")
	void buscarBarbeiroComSucesso() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(ArgumentMatchers.anyString())).thenReturn(Optional.of(entity));
		
		//acao
		BarbeiroEntity retorno = repository.buscarPorId(entity.getCpf());

	    // verificação
	    assertThat(retorno).isEqualTo(entity);
	}
	
	@Test
	@DisplayName("Buscar barbeiro sem sucesso, id não encontrado.")
	void buscarBarbeiroSemSucessoIdNaoEncontrado() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		
		when(springRepository.findByIdQuandoEstaAtivo(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
		
		//acao e verificação
		assertThrows(IdNaoEncontradoException.class, () -> repository.buscarPorId(entity.getCpf()));
	}
	
	@Test
	@DisplayName("Paginar todos os barbeiro com sucesso.")
	void paginarTodosBarbeirosComSucesso() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		PageRequest pagina = PageRequest.of(0, 10);
		
		when(springRepository.findAllQuandoEstaAtivo(pagina)).thenReturn(new PageImpl<>(List.of(entity)));
		
		//acao
		Page<BarbeiroEntity> retorno = repository.buscarTodos(pagina);

	    // verificação
	    assertThat(retorno)
	    .isNotNull()
	    .isNotEmpty()
	    .hasSize(1);
	    
	    assertThat(retorno.toList().get(0)).isEqualTo(entity);
	}

}
