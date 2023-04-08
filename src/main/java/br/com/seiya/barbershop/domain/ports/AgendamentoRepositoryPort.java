package br.com.seiya.barbershop.domain.ports;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.adapter.data.entities.AgendamentoEntity;

public interface AgendamentoRepositoryPort {

	AgendamentoEntity salvar(AgendamentoEntity Agendamento);

	AgendamentoEntity buscarPorId(Long id);

	Page<AgendamentoEntity> buscarTodos(Pageable pagina);

}
