package br.com.seiya.barbershop.adapter.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import br.com.seiya.barbershop.util.BarbeiroRequestCreator;
import br.com.seiya.barbershop.util.BarbeiroResponseCreator;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste para o controller de barbeiros.")
class BarbeiroControllerTest {
	
	@InjectMocks
	private BarbeiroController controller;
	
	@Mock
	private BarbeiroServicePort service;

	@Test
	@DisplayName("Cadastrar barbeiro com sucesso.")
	void cadastrarBarbeiroComSucesso() {
		// cenario
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		when(service.cadastrar(ArgumentMatchers.any(BarbeiroRequest.class))).thenReturn(response);
		
		//acao
		ResponseEntity<BarbeiroResponse> http = controller.cadastrarBarbeiro(BarbeiroRequestCreator.paraSalvar());

	    // verificação
	    assertThat(http.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	    assertThat(http.getBody()).isEqualTo(response);
	}
	


	@Test
	@DisplayName("Buscar barbeiro com sucesso.")
	void buscarBarbeiroComSucesso() {
		// cenario
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		when(service.buscarPorId(ArgumentMatchers.anyString())).thenReturn(response);
		
		// acao
		ResponseEntity<BarbeiroResponse> http = controller.buscaBarbeiro(BarbeiroRequestCreator.paraSalvar().cpf);
		
		// verificacao
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}


	@Test
	@DisplayName("Paginar barbeiros com sucesso.")
	void paginarBarbeirosComSucesso() {
		// cenário
		Page<BarbeiroResponse> pagina = new PageImpl<BarbeiroResponse>(List.of(BarbeiroResponseCreator.paraSalvar()));
		PageRequest pageRequest = PageRequest.of(1, 1);
		when(service.paginarBarbeiros(pageRequest)).thenReturn(pagina);
				
		// ação
		ResponseEntity<Page<BarbeiroResponse>> http = controller.paginarBarbeiro(pageRequest);
				
		// verificação
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);
				
		assertThat(pagina).isEqualTo(http.getBody());
	}

	@Test
	@DisplayName("Atualizar barbeiro com sucesso.")
	void atualizarBarbeirosComSucesso() {
		// cenario
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		BarbeiroRequest request = BarbeiroRequestCreator.paraSalvar();
		when(service.atualizarBarbeiro(ArgumentMatchers.anyString(), ArgumentMatchers.any(BarbeiroRequest.class))).thenReturn(response);
		
		// acao
		ResponseEntity<BarbeiroResponse> http = controller.atualizarBarbeiro(request.cpf, request);
		
		// verificacao
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}

	@Test
	@DisplayName("Deletar barbeiro com sucesso.")
	void deletarBarbeiroComSucesso() {
		// cenario
		BarbeiroRequest request = BarbeiroRequestCreator.paraSalvar();
		
		// acao
		ResponseEntity<BarbeiroResponse> http = controller.deletarBarbeiro(request.cpf);
		
		// verificacao
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	    assertThat(http.getBody()).isNull();
	}

}
