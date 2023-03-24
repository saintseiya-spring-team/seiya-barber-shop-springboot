package br.com.seiya.barbershop.infraestrutura.adaptadores.entidades;

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
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dia;

    private LocalDateTime horario;

    @ManyToOne
    @JoinColumn(name = "barbeiro_id")
    @NotNull
    private BarbeiroEntity barbeiro;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @NotNull
    private ClienteEntity clienteEntity;

    @ManyToOne
    @JoinColumn(name = "servico_id")
    @NotNull
    private ServicoEntity servico;

}
