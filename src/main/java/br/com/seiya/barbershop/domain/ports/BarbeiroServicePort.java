package br.com.seiya.barbershop.domain.ports;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;

public interface BarbeiroServicePort {
	
	public BarbeiroResponse cadastrar(BarbeiroRequest barbeiro);
	
	public BarbeiroResponse buscarPorId(String cpf);
	
	public Page<BarbeiroResponse> paginarBarbeiros(Pageable pagima);
	
	public BarbeiroResponse atualizarBarbeiro(String cpf, @Valid BarbeiroRequest dados);

	public void exclusaoLogicaBarbeiro(String cpf);
		
}
