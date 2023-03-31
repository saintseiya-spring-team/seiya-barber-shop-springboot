package br.com.seiya.barbershop.adapter.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.domain.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BarbeiroRepositoryImp implements BarbeiroRepositoryPort{
	
	
	private final BarbeiroJpaRepository springRepository;

	@Override
	public BarbeiroEntity salvar(BarbeiroEntity barbeiro) {
		//TODO verificar caso tentem salvar um que ja existe
		return springRepository.save(barbeiro);
	}

	@Override
	public BarbeiroEntity buscarPorId(Long id) {
		return springRepository.findByIdQuandoEstaAtivo(id).orElseThrow(IdNaoEncontradoException::new);
	}

	@Override
	public Page<BarbeiroEntity> buscarTodos(Pageable pagima) {
		return springRepository.findAllQuandoEstaAtivo(pagima);
	}

}
