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

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "barbeiros")
@Data
@NoArgsConstructor
public class BarbeiroEntity {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @JoinTable(
            name = "barbeiros_servicos",
            joinColumns = @JoinColumn(name ="barbeiro_id"),
            inverseJoinColumns = @JoinColumn(name ="servico_id")
    )
    @ElementCollection(targetClass = ServicoEntity.class)
    private List<ServicoEntity> servicos = new ArrayList<>();

    public BarbeiroEntity(BarbeiroDTO barbeiro) {
    	this.email = barbeiro.email;
    	this.nome = barbeiro.nome;
    	this.telefone = barbeiro.telefone;
    }

}
