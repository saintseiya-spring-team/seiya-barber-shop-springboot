package br.com.seya.clienteservice.infraestrutura.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "barbeiro_id")
	@NotNull
	private Barbeiro barbeiro;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@NotNull
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "funcao_id")
	@NotNull
	private Funcao funcao;
	
	private LocalDate dia;
	
	private LocalDateTime horario;
}
