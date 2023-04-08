package br.com.seiya.barbershop.domain.dtos;

import java.time.LocalTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Builder;

@Builder
public class BarbeiroRequest {

	@NotBlank
	@CPF
    public String cpf;
	@NotBlank
    public String nome;
	public Boolean ativo;
	@NotBlank
	@Email
    public String email;
//	@NotBlank
//    public String senha;
	@NotBlank
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
