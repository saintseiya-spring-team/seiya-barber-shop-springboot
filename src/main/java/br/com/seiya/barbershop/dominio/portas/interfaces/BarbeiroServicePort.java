package br.com.seiya.barbershop.dominio.portas.interfaces;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;

public interface BarbeiroServicePort {
	
	public void cadastrar(BarbeiroDTO barbeiro);
		
}
