package br.com.seiya.barbershop.dominio.portas.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.BarbeiroEntity;

public interface BarbeiroRepositoryPort {

	BarbeiroEntity salvar(BarbeiroDTO barbeiro);

	BarbeiroEntity buscarPorId(Long id);

	Page<BarbeiroEntity> buscarTodos(Pageable pagina);

}
