package br.com.seiya.barbershop.util.Barbeiro;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;

public class BarbeiroEntityCreator {
	

	public static BarbeiroEntity paraSalvar() {
		return BarbeiroEntity.builder()
				.ativo(true)
				.cpf(BarbeiroRequestCreator.paraSalvar().cpf)
				.email(BarbeiroRequestCreator.paraSalvar().email)
				.nome(BarbeiroRequestCreator.paraSalvar().nome)
				.telefone(BarbeiroRequestCreator.paraSalvar().telefone)
				.build();
	}
	
	public static BarbeiroEntity paraAtualizar() {
		return BarbeiroEntity.builder()
				.ativo(true)
				.cpf(BarbeiroRequestCreator.paraAtualizar().cpf)
				.email(BarbeiroRequestCreator.paraAtualizar().email)
				.nome(BarbeiroRequestCreator.paraAtualizar().nome)
				.telefone(BarbeiroRequestCreator.paraAtualizar().telefone)
				.build();
	}
}
