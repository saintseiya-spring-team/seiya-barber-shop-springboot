package br.com.seiya.barbershop.domain.ports;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.domain.dtos.Barbeiro;
import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;

public interface BarbeiroServicePort {
	
	public BarbeiroResponse cadastrar(BarbeiroRequest barbeiro);
	
	public BarbeiroResponse buscarPorId(Long id);
	
	public Page<BarbeiroResponse> paginarBarbeiros(Pageable pagima);
	
	public BarbeiroResponse atualizarBarbeiro(Long id, @Valid Barbeiro dados);

	public void exclusaoLogicaBarbeiro(Long id);
		
}
