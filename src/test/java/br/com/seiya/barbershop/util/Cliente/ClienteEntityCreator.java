package br.com.seiya.barbershop.util.Cliente;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;

public class ClienteEntityCreator {
	

	public static ClienteEntity paraSalvar() {
		return ClienteEntity.builder()
				.status(true)
				.cpf(ClienteRequestCreator.paraSalvar().cpf)
				.email(ClienteRequestCreator.paraSalvar().email)
				.nome(ClienteRequestCreator.paraSalvar().nome)
				.telefone(ClienteRequestCreator.paraSalvar().telefone)
				.build();
	}
	
	public static ClienteEntity paraAtualizar() {
		return ClienteEntity.builder()
				.status(true)
				.cpf(ClienteRequestCreator.paraAtualizar().cpf)
				.email(ClienteRequestCreator.paraAtualizar().email)
				.nome(ClienteRequestCreator.paraAtualizar().nome)
				.telefone(ClienteRequestCreator.paraAtualizar().telefone)
				.build();
	}
}
