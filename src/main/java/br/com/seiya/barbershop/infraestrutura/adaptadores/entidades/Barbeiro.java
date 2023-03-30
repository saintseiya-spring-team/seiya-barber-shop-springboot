package br.com.seiya.barbershop.infraestrutura.adaptadores.entidades;

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

import br.com.seiya.barbershop.dominio.dtos.BarbeiroCadastroDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "barbeiros")
@Data
@NoArgsConstructor
public class Barbeiro {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private Boolean ativo;

    private String nome;

    private String email;

    private String telefone;

    @JoinTable(
            name = "barbeiros_servicos",
            joinColumns = @JoinColumn(name ="barbeiro_id"),
            inverseJoinColumns = @JoinColumn(name ="servico_id")
    )
    @ElementCollection(targetClass = Servico.class)
    private List<Servico> servicos = new ArrayList<>();

    public Barbeiro(BarbeiroCadastroDTO barbeiro) {
    	this.email = barbeiro.email;
    	this.nome = barbeiro.nome;
    	this.telefone = barbeiro.telefone;
    	this.ativo = true;
    }

}
