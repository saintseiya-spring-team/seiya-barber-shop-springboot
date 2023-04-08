package br.com.seiya.barbershop.adapter.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroRequestCreator;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroResponseCreator;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste para o controller de barbeiros.")
class BarbeiroControllerTest {
	
	@InjectMocks
	private BarbeiroController controller;
	
	@Mock
	private BarbeiroServicePort service;

	@Test
	void cadastrarBarbeiroComSucesso() {
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		when(service.cadastrar(any(BarbeiroRequest.class))).thenReturn(response);
		
		ResponseEntity<BarbeiroResponse> http = controller.cadastrar(BarbeiroRequestCreator.paraSalvar());

	    assertThat(http.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	    assertThat(http.getBody()).isEqualTo(response);
	}
	


	@Test
	void buscarBarbeiroComSucesso() {
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		when(service.buscarPorId(anyString())).thenReturn(response);
		
		ResponseEntity<BarbeiroResponse> http = controller.buscar(BarbeiroRequestCreator.paraSalvar().cpf);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}


	@Test
	void paginarBarbeirosComSucesso() {
		Page<BarbeiroResponse> pagina = new PageImpl<BarbeiroResponse>(List.of(BarbeiroResponseCreator.paraSalvar()));
		PageRequest pageRequest = PageRequest.of(1, 1);
		when(service.paginar(pageRequest)).thenReturn(pagina);
				
		ResponseEntity<Page<BarbeiroResponse>> http = controller.paginar(pageRequest);
				
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);
				
		assertThat(pagina).isEqualTo(http.getBody());
	}

	@Test
	void atualizarBarbeirosComSucesso() {
		BarbeiroResponse response = BarbeiroResponseCreator.paraSalvar();
		BarbeiroRequest request = BarbeiroRequestCreator.paraSalvar();
		when(service.atualizar(anyString(), any(BarbeiroRequest.class))).thenReturn(response);
		
		ResponseEntity<BarbeiroResponse> http = controller.atualizar(request.cpf, request);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}

	@Test
	void deletarBarbeiroComSucesso() {
		BarbeiroRequest request = BarbeiroRequestCreator.paraSalvar();
		
		ResponseEntity<BarbeiroResponse> http = controller.deletar(request.cpf);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	    assertThat(http.getBody()).isNull();
	}

}
