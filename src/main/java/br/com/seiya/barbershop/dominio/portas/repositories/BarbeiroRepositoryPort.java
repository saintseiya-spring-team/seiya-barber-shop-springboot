package br.com.seiya.barbershop.dominio.portas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroCadastroDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public interface BarbeiroRepositoryPort {

	Barbeiro salvar(BarbeiroCadastroDTO barbeiro);

	Barbeiro buscarPorId(Long id);

	Page<Barbeiro> buscarTodos(Pageable pagima);

}
