package br.com.seiya.barbershop.domain.dtos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;
import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import lombok.Builder;

@Builder
public class AgendamentoResponse {

    public Long id;
    
    public Boolean status;

	public Boolean pendente;

    public LocalDate dia;

    public LocalTime horario;

    public BarbeiroEntity barbeiro;

    public ClienteEntity cliente;

    public ServicoEntity servico;
    
    
	
}
