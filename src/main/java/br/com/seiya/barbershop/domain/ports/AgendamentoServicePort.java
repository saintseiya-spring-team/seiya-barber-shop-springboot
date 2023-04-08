package br.com.seiya.barbershop.domain.ports;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.domain.dtos.AgendamentoRequest;
import br.com.seiya.barbershop.domain.dtos.AgendamentoResponse;

public interface AgendamentoServicePort {
	
	public AgendamentoResponse cadastrar(AgendamentoRequest barbeiro);
	
	public AgendamentoResponse buscarPorId(Long id);
	
	public Page<AgendamentoResponse> paginar(Pageable pagima);
	
	public AgendamentoResponse atualizar(Long id, @Valid AgendamentoRequest dados);

	public void exclusaoLogica(Long id);

		
}