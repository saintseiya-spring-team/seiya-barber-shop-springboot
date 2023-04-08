package br.com.seiya.barbershop.adapter.data.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "agendamentos")
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dia;

    private LocalTime horario;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    @NotNull
    private BarbeiroEntity barbeiro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    @NotNull
    private ServicoEntity servico;
    
    private Boolean status;
    
    private Boolean pendente;

}
