package br.com.seiya.barbershop.dominio.portas.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.BarbeiroEntity;

public interface BarbeiroServicePort {
	
	public BarbeiroEntity cadastrar(BarbeiroDTO barbeiro);
	public BarbeiroEntity buscarPorId(Long id);
	public Page<BarbeiroResponseDTO> paginarBarbeiros(Pageable pagina);
		
}
