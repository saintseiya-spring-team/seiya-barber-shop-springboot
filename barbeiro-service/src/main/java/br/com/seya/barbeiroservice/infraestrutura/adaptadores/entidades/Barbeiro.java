package br.com.seya.barbeiroservice.infraestrutura.adaptadores.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Entity
@Table(name = "barbeiros")
public class Barbeiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	@JoinTable(
			name = "barbeiros_funcoes",
			joinColumns = @JoinColumn(name ="barbeiro_id"),
			inverseJoinColumns = @JoinColumn(name ="servico_id")
	)
	@ElementCollection(targetClass = Servicos.class)
	private List<Servicos> servicos = new ArrayList<>();
	

}