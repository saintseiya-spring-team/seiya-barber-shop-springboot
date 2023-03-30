package br.com.seiya.barbershop.dominio.portas.interfaces;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroCadastroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.dominio.dtos.BarbeiroResponseDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public interface BarbeiroServicePort {
	
	public Barbeiro cadastrar(BarbeiroCadastroDTO barbeiro);
	
	public BarbeiroResponseDTO buscarPorId(Long id);
	
	public Page<BarbeiroResponseDTO> paginarBarbeiros(Pageable pagima);
	
	public BarbeiroResponseDTO atualizarBarbeiro(Long id, @Valid BarbeiroDTO dados);

	public void exclusaoLogicaBarbeiro(Long id);
		
}
