package br.com.seiya.barbershop.domain.ports;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;

public interface ClienteRepositoryPort {

	ClienteEntity salvar(ClienteEntity cliente);

	ClienteEntity buscarPorId(String cpf);

	Page<ClienteEntity> buscarTodos(Pageable pagina);

}
