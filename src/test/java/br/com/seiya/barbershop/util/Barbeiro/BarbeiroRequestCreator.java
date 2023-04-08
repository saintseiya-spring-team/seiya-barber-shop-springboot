package br.com.seiya.barbershop.util.Barbeiro;

import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;

public class BarbeiroRequestCreator {
	

	public static BarbeiroRequest paraSalvar() {
		return BarbeiroRequest.builder()
				.cpf("85228665030")
				.email("algum@gmail.com")
				.nome("Jonas")
				.telefone("3232323232")
				.build();
	}
	
	public static BarbeiroRequest paraAtualizar() {
		return BarbeiroRequest.builder()
				.cpf("85228665030")
				.email("emailatualizado@gmail.com")
				.nome("Nome Atualizado")
				.telefone("telefoneatualizado")
				.build();
	}
}
