package br.com.seiya.barbershop.adapter.data.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {
	
	@Id
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	private Boolean status;
	
}
