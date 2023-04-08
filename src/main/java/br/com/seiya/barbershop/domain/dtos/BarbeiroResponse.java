package br.com.seiya.barbershop.domain.dtos;

import java.time.LocalTime;

import lombok.Builder;
@Builder
public class BarbeiroResponse {


	public String cpf;
	
	public Boolean ativo;

	public String nome;

	public String email;

	public String telefone;
	
	public Boolean domingo;

    public Boolean segunda;

    public Boolean terca;

    public Boolean quarta;

    public Boolean quinta;

    public Boolean sexta;

    public Boolean sabado;

    public LocalTime inicioExpediente;

    public LocalTime finalExpediente;
}
