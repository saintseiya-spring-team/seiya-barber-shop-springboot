package br.com.seiya.barbershop.domain.ports;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;

public interface ServicoRepositoryPort {

	ServicoEntity salvar(ServicoEntity servico);

	ServicoEntity buscarPorId(Long id);
	
	List<ServicoEntity> buscarPorNomeBarbeiro(String nome);

	Page<ServicoEntity> buscarTodos(Pageable pagina);
	
	List<ServicoEntity> buscarTodos();

	List<ServicoEntity> buscarPorTipo(ServicoTipoEnum tipo);

	List<ServicoEntity> buscarPorTipoEDisponbilidade(ServicoTipoEnum tipo, String diaDaSemana,
			LocalTime horarioAtendimento);

}
