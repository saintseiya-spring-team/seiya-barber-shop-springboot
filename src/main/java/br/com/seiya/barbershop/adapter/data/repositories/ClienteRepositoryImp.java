package br.com.seiya.barbershop.adapter.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;
import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
import br.com.seiya.barbershop.domain.ports.ClienteRepositoryPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryImp implements ClienteRepositoryPort{
	
	
	private final ClienteJpaRepository springRepository;

	@Override
	public ClienteEntity salvar(ClienteEntity cliente) {
		springRepository.findByIdQuandoEstaAtivo(cliente.getCpf()).ifPresent(b -> { throw new IdJaCadastradoException("O CPF "+ b.getCpf() + " já está cadastrado"); });
		return springRepository.save(cliente);
	}

	@Override
	public ClienteEntity buscarPorId(String cpf) {
		return springRepository.findByIdQuandoEstaAtivo(cpf).orElseThrow(IdNaoEncontradoException::new);
	}

	@Override
	public Page<ClienteEntity> buscarTodos(Pageable pagina) {
		return springRepository.findAllQuandoEstaAtivo(pagina);
	}

}
