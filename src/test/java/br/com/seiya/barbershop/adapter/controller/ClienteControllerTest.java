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

import br.com.seiya.barbershop.domain.dtos.ClienteRequest;
import br.com.seiya.barbershop.domain.dtos.ClienteResponse;
import br.com.seiya.barbershop.domain.ports.ClienteServicePort;
import br.com.seiya.barbershop.util.Cliente.ClienteRequestCreator;
import br.com.seiya.barbershop.util.Cliente.ClienteResponseCreator;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste para o controller de Clientes.")
class ClienteControllerTest {
	
	@InjectMocks
	private ClienteController controller;
	
	@Mock
	private ClienteServicePort service;

	@Test
	void cadastrarClienteComSucesso() {
		ClienteResponse response = ClienteResponseCreator.paraSalvar();
		when(service.cadastrar(any(ClienteRequest.class))).thenReturn(response);
		
		ResponseEntity<ClienteResponse> http = controller.cadastrar(ClienteRequestCreator.paraSalvar());

	    assertThat(http.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	    assertThat(http.getBody()).isEqualTo(response);
	}
	


	@Test
	void buscarClienteComSucesso() {
		ClienteResponse response = ClienteResponseCreator.paraSalvar();
		when(service.buscarPorId(anyString())).thenReturn(response);
		
		ResponseEntity<ClienteResponse> http = controller.buscar(ClienteRequestCreator.paraSalvar().cpf);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}


	@Test
	void paginarClientesComSucesso() {
		Page<ClienteResponse> pagina = new PageImpl<ClienteResponse>(List.of(ClienteResponseCreator.paraSalvar()));
		PageRequest pageRequest = PageRequest.of(1, 1);
		when(service.paginar(pageRequest)).thenReturn(pagina);
				
		ResponseEntity<Page<ClienteResponse>> http = controller.paginar(pageRequest);
				
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);
				
		assertThat(pagina).isEqualTo(http.getBody());
	}

	@Test
	void atualizarClientesComSucesso() {
		ClienteResponse response = ClienteResponseCreator.paraSalvar();
		ClienteRequest request = ClienteRequestCreator.paraSalvar();
		when(service.atualizar(anyString(), any(ClienteRequest.class))).thenReturn(response);
		
		ResponseEntity<ClienteResponse> http = controller.atualizar(request.cpf, request);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}

	@Test
	void deletarClienteComSucesso() {
		ClienteRequest request = ClienteRequestCreator.paraSalvar();
		
		ResponseEntity<ClienteResponse> http = controller.deletar(request.cpf);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	    assertThat(http.getBody()).isNull();
	}

}
