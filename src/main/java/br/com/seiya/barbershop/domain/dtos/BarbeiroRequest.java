package br.com.seiya.barbershop.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;


//TODO ver https://mapstruct.org/ para converter um objeto em outro tipo de objeto
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

}
