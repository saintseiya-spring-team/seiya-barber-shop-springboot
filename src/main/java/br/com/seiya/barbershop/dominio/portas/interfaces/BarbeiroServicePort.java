package br.com.seiya.barbershop.dominio.portas.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public interface BarbeiroServicePort {
	
	public Barbeiro cadastrar(BarbeiroDTO barbeiro);
	public Barbeiro buscarPorId(Long id);
	public Page<BarbeiroResponseDTO> paginarBarbeiros(Pageable pagina);
		
}
