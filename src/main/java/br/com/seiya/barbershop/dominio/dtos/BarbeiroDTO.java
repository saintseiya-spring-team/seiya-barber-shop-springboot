package br.com.seiya.barbershop.dominio.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class BarbeiroDTO {

	@NotBlank
    public String nome;
	@NotBlank
	@Email
    public String email;
	@NotBlank
    public String telefone;

}
