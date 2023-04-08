package br.com.seiya.barbershop.adapter.data.entities;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "barbeiros")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarbeiroEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    private String cpf;
	
	private Boolean ativo;

    private String nome;

    private String email;

    private String telefone;
    
    private Boolean domingo;

    private Boolean segunda;

    private Boolean terca;

    private Boolean quarta;

    private Boolean quinta;

    private Boolean sexta;

    private Boolean sabado;

    private LocalTime inicioExpediente;

    private LocalTime finalExpediente;
}
