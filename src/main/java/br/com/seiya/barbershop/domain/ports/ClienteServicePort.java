package br.com.seiya.barbershop.domain.ports;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.domain.dtos.ClienteRequest;
import br.com.seiya.barbershop.domain.dtos.ClienteResponse;

public interface ClienteServicePort {
	
	public ClienteResponse cadastrar(ClienteRequest barbeiro);
	
	public ClienteResponse buscarPorId(String cpf);
	
	public Page<ClienteResponse> paginar(Pageable pagima);
	
	public ClienteResponse atualizar(String cpf, @Valid ClienteRequest dados);

	public void exclusaoLogica(String cpf);
		
}
