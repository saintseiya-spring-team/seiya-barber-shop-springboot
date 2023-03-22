package br.com.seya.agendamentoservice.infraestrutura.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "funcoes")
public class Funcao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String funcaoTipo;
	private BigDecimal preco;
	private LocalDateTime duracao;
	@ManyToMany(mappedBy = "funcoes")
	private List<Barbeiro> listaBarbeiro = new ArrayList<>();
}
