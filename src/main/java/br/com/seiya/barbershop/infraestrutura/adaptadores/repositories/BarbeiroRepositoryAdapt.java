package br.com.seiya.barbershop.infraestrutura.adaptadores.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroCadastroDTO;
import br.com.seiya.barbershop.dominio.exceptions.IdNaoEncontrado;
import br.com.seiya.barbershop.dominio.portas.repositories.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

@Component
public class BarbeiroRepositoryAdapt implements BarbeiroRepositoryPort{
	
	@Autowired
	private SpringBarbeiroRepository springRepository;

	@Override
	public Barbeiro salvar(BarbeiroCadastroDTO barbeiro) {
		return springRepository.save(new Barbeiro(barbeiro));
	}

	@Override
	public Barbeiro buscarPorId(Long id) {
		return springRepository.findByIdQuandoEstaAtivo(id).orElseThrow(IdNaoEncontrado::new);
	}

	@Override
	public Page<Barbeiro> buscarTodos(Pageable pagima) {
		return springRepository.findAllQuandoEstaAtivo(pagima);
	}

}
