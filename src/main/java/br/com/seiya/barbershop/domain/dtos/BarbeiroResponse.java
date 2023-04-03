package br.com.seiya.barbershop.domain.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
@Builder
@EqualsAndHashCode
public class BarbeiroResponse {


	public String cpf;
	
	public Boolean ativo;

	public String nome;

	public String email;

	public String telefone;

	public List<ServicoEntity> servicos = new ArrayList<>();
    
}
