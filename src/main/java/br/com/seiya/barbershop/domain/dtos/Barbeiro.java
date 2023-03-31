package br.com.seiya.barbershop.domain.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Barbeiro {

	@NotBlank
    public String nome;
	public Boolean ativo;
	@NotBlank
	@Email
    public String email;
//	@NotBlank
//  public String senha;
	@NotBlank
    public String telefone;

}
