package br.com.seiya.barbershop.util;

import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;
public class BarbeiroResponseCreator {
	

	public static BarbeiroResponse paraSalvar() {
		return BarbeiroResponse.builder()
				.ativo(BarbeiroEntityCreator.paraSalvar().getAtivo())
				.cpf(BarbeiroEntityCreator.paraSalvar().getCpf())
				.email(BarbeiroEntityCreator.paraSalvar().getEmail())
				.nome(BarbeiroEntityCreator.paraSalvar().getNome())
				.telefone(BarbeiroEntityCreator.paraSalvar().getTelefone())
				.build();
	}
	
	public static BarbeiroResponse paraAtualizar() {
		return BarbeiroResponse.builder()
				.ativo(BarbeiroEntityCreator.paraAtualizar().getAtivo())
				.cpf(BarbeiroEntityCreator.paraAtualizar().getCpf())
				.email(BarbeiroEntityCreator.paraAtualizar().getEmail())
				.nome(BarbeiroEntityCreator.paraAtualizar().getNome())
				.telefone(BarbeiroEntityCreator.paraAtualizar().getTelefone())
				.build();
	}
	
}
