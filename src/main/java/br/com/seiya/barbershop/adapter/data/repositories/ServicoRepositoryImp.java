package br.com.seiya.barbershop.adapter.data.repositories;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.ServicoNaoCadastradoException;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.domain.ports.ServicoRepositoryPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ServicoRepositoryImp implements ServicoRepositoryPort{
	
	
	private final ServicoJpaRepository springRepository;

	@Override
	public ServicoEntity salvar(ServicoEntity servico) {
		springRepository.findByIdQuandoEstaAtivo(servico.getId()).ifPresent(b -> { throw new IdJaCadastradoException("O id "+ b.getId() + " já está cadastrado"); });
		return springRepository.save(servico);
	}

	@Override
	public ServicoEntity buscarPorId(Long id) {
		return springRepository.findByIdQuandoEstaAtivo(id).orElseThrow(IdNaoEncontradoException::new);
	}

	@Override
	public Page<ServicoEntity> buscarTodos(Pageable pagina) {
		return springRepository.findAllQuandoEstaAtivo(pagina);
	}

	@Override
	public List<ServicoEntity> buscarPorNomeBarbeiro(String nome) {
		if(springRepository.findByNomeBarbeiroQuandoEstativo(nome).isEmpty()) {throw new ServicoNaoCadastradoException("Não há serviços com barbeiros que tem esse nome");}
		return springRepository.findByNomeBarbeiroQuandoEstativo(nome);
	}

	@Override
	public List<ServicoEntity> buscarPorTipo(ServicoTipoEnum tipo) {
		if(springRepository.findByTipoQuandoEstativo(tipo).isEmpty()) {throw new ServicoNaoCadastradoException("Não há serviços que atendam o tipo selecionado");}
		return springRepository.findByTipoQuandoEstativo(tipo);
	}
	
	@Override
	public List<ServicoEntity> buscarPorTipoEDisponbilidade(ServicoTipoEnum tipo, String diaDaSemana, LocalTime horarioAtendimento) {
		if(springRepository.findByDisponibilidadeETipoQuandoEstativo(tipo, diaDaSemana, horarioAtendimento).isEmpty()) {throw new ServicoNaoCadastradoException("Não há serviços que atendam o tipo selecionado");}
		return springRepository.findByTipoQuandoEstativo(tipo);
	}
	
	@Override
	public List<ServicoEntity> buscarTodos() {
		return springRepository.findAll();
	}

}
