package br.com.seiya.barbershop.domain.dtos;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
public class ClienteResponse {

	public String cpf;

	public String nome;

	public Boolean status;

	public String email;

	public String telefone;

}
