package br.com.seiya.barbershop.adapter.data.repositories;

import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BarbeiroRepositoryImp implements BarbeiroRepositoryPort{
	
	
	private final BarbeiroJpaRepository springRepository;

	@Override
	public BarbeiroEntity salvar(BarbeiroEntity barbeiro) {
		springRepository.findByIdQuandoEstaAtivo(barbeiro.getCpf()).ifPresent(b -> { throw new IdJaCadastradoException("O CPF "+ b.getCpf() + " já está cadastrado"); });
		return springRepository.save(barbeiro);
	}

	@Override
	public BarbeiroEntity buscarPorId(String cpf) {
		return springRepository.findByIdQuandoEstaAtivo(cpf).orElseThrow(IdNaoEncontradoException::new);
	}

	@Override
	public Page<BarbeiroEntity> buscarTodos(Pageable pagina) {
		return springRepository.findAllQuandoEstaAtivo(pagina);
	}

}
