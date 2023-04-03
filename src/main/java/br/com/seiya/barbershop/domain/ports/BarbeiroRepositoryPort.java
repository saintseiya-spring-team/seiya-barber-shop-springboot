package br.com.seiya.barbershop.domain.ports;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;

public interface BarbeiroRepositoryPort {

	BarbeiroEntity salvar(BarbeiroEntity barbeiro);

	BarbeiroEntity buscarPorId(String cpf);

	Page<BarbeiroEntity> buscarTodos(Pageable pagima);

}
