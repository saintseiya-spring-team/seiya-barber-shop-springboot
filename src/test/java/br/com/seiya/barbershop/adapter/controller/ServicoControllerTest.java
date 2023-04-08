package br.com.seiya.barbershop.adapter.controller;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.domain.ports.ServicoServicePort;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;
import br.com.seiya.barbershop.util.Servico.ServicoEntityCreator;
import br.com.seiya.barbershop.util.Servico.ServicoRequestCreator;
import br.com.seiya.barbershop.util.Servico.ServicoResponseCreator;

@ExtendWith(MockitoExtension.class)
@DisplayName("Teste para o controller de Servicos.")
class ServicoControllerTest {
	
	@InjectMocks
	private ServicoController controller;
	
	@Mock
	private ServicoServicePort service;

	@Test
	void cadastrarServicoComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		when(service.cadastrar(any(ServicoRequest.class))).thenReturn(response);
		
		ResponseEntity<ServicoResponse> http = controller.cadastrar(ServicoRequestCreator.paraSalvar());

	    assertThat(http.getStatusCode()).isEqualTo(HttpStatus.CREATED);

	    assertThat(http.getBody()).isEqualTo(response);
	}
	


	@Test
	void buscarServicoComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		when(service.buscarPorId(anyLong())).thenReturn(response);
		
		ResponseEntity<ServicoResponse> http = controller.buscar(1l);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}
	
	@Test
	void buscarPorBarbeiroComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		when(service.buscarPorNomeBarbeiro(anyString())).thenReturn(List.of(response));
		
		ResponseEntity<List<ServicoResponse>> http = controller.buscarPorBarbeiro(BarbeiroEntityCreator.paraSalvar().getCpf());
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		assertThat(http.getBody()).contains(response);
	}
	
	@Test
	void buscarPorTipoComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		when(service.buscarPorTipo(any(ServicoTipoEnum.class))).thenReturn(List.of(response));
		
		ResponseEntity<List<ServicoResponse>> http = controller.buscarPorTipo(ServicoEntityCreator.paraSalvar().getTipo());
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		assertThat(http.getBody()).contains(response);
	}


	@Test
	void paginarServicosComSucesso() {
		Page<ServicoResponse> pagina = new PageImpl<ServicoResponse>(List.of(ServicoResponseCreator.paraSalvar()));
		PageRequest pageRequest = PageRequest.of(1, 1);
		when(service.paginar(pageRequest)).thenReturn(pagina);
				
		ResponseEntity<Page<ServicoResponse>> http = controller.paginar(pageRequest);
				
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);
				
		assertThat(pagina).isEqualTo(http.getBody());
	}

	@Test
	void atualizarServicosComSucesso() {
		ServicoResponse response = ServicoResponseCreator.paraSalvar();
		ServicoRequest request = ServicoRequestCreator.paraSalvar();
		when(service.atualizar(anyLong(), any(ServicoRequest.class))).thenReturn(response);
		
		ResponseEntity<ServicoResponse> http = controller.atualizar(1l, request);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.OK);

	    assertThat(http.getBody()).isEqualTo(response);
	}

	@Test
	void deletarServicoComSucesso() {
		
		ResponseEntity<ServicoResponse> http = controller.deletar(1l);
		
		assertThat(http.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);

	    assertThat(http.getBody()).isNull();
	}

}
