package br.com.seiya.barbershop.dominio.portas.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public interface BarbeiroRepositoryPort {

	Barbeiro salvar(BarbeiroDTO barbeiro);

	Barbeiro buscarPorId(Long id);

	Page<Barbeiro> buscarTodos(Pageable pagina);

}
