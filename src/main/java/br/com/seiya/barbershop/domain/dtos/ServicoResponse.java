package br.com.seiya.barbershop.domain.dtos;

import java.math.BigDecimal;
import java.time.Duration;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import lombok.Builder;

@Builder
public class ServicoResponse {

	public Long id;

	public ServicoTipoEnum tipo;

	public BigDecimal preco;

	public Long duracaoEmMinutos;

	public Boolean status;

	public BarbeiroEntity barbeiro;

}
