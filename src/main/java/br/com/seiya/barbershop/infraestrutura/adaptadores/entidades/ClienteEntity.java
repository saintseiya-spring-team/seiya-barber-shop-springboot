package br.com.seiya.barbershop.infraestrutura.adaptadores.entidades;

import br.com.seiya.barbershop.dominio.Cliente;
import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private Boolean status;

	public ClienteEntity(ClienteDTO clienteDTO) {
		this.id = clienteDTO.id;
		this.email = clienteDTO.email;
		this.telefone = clienteDTO.telefone;
		this.status = clienteDTO.status;
	}

	
}
