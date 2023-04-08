package br.com.seiya.barbershop.adapter.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.adapter.data.entities.AgendamentoEntity;
import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.domain.ports.AgendamentoRepositoryPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AgendamentoRepositoryImp implements AgendamentoRepositoryPort{
	
	
	private final AgendamentoJpaRepository springRepository;

	@Override
	public AgendamentoEntity salvar(AgendamentoEntity Agendamento) {
		springRepository.findByIdQuandoEstaAtivo(Agendamento.getId()).ifPresent(b -> { throw new IdJaCadastradoException("O ID "+ b.getId() + " já está cadastrado"); });
		return springRepository.save(Agendamento);
	}

	@Override
	public AgendamentoEntity buscarPorId(Long id) {
		return springRepository.findByIdQuandoEstaAtivo(id).orElseThrow(IdNaoEncontradoException::new);
	}

	@Override
	public Page<AgendamentoEntity> buscarTodos(Pageable pagina) {
		return springRepository.findAllQuandoEstaAtivo(pagina);
	}

}
