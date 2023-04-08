package br.com.seiya.barbershop.util.Cliente;

import br.com.seiya.barbershop.domain.dtos.ClienteRequest;

public class ClienteRequestCreator {
	

	public static ClienteRequest paraSalvar() {
		return ClienteRequest.builder()
				.cpf("85228665030")
				.email("algum@gmail.com")
				.nome("Jonas")
				.telefone("3232323232")
				.build();
	}
	
	public static ClienteRequest paraAtualizar() {
		return ClienteRequest.builder()
				.cpf("85228665030")
				.email("emailatualizado@gmail.com")
				.nome("Nome Atualizado")
				.telefone("telefoneatualizado")
				.build();
	}
}
