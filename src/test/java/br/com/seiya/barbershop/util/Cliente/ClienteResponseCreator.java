package br.com.seiya.barbershop.util.Cliente;

import br.com.seiya.barbershop.domain.dtos.ClienteResponse;
public class ClienteResponseCreator {
	

	public static ClienteResponse paraSalvar() {
		return ClienteResponse.builder()
				.status(ClienteEntityCreator.paraSalvar().getStatus())
				.cpf(ClienteEntityCreator.paraSalvar().getCpf())
				.email(ClienteEntityCreator.paraSalvar().getEmail())
				.nome(ClienteEntityCreator.paraSalvar().getNome())
				.telefone(ClienteEntityCreator.paraSalvar().getTelefone())
				.build();
	}
	
	public static ClienteResponse paraAtualizar() {
		return ClienteResponse.builder()
				.status(ClienteEntityCreator.paraAtualizar().getStatus())
				.cpf(ClienteEntityCreator.paraAtualizar().getCpf())
				.email(ClienteEntityCreator.paraAtualizar().getEmail())
				.nome(ClienteEntityCreator.paraAtualizar().getNome())
				.telefone(ClienteEntityCreator.paraAtualizar().getTelefone())
				.build();
	}
	
}
