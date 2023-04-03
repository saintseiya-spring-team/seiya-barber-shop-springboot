package br.com.seiya.barbershop.adapter.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "barbeiros")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarbeiroEntity {
	@Id
    private String cpf;
	
	private Boolean ativo;

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


}
