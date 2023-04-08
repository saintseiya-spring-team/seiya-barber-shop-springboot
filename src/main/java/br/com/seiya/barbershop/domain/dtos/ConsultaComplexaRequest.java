package br.com.seiya.barbershop.domain.dtos;

import java.time.LocalTime;

import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;

public class ConsultaComplexaRequest {

	public ServicoTipoEnum tipo;
	
	public String diaDaSemana ;
	
	public LocalTime horarioAtendimento;
}
