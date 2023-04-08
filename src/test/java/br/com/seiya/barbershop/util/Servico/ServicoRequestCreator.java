package br.com.seiya.barbershop.util.Servico;

import java.math.BigDecimal;

import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;

public class ServicoRequestCreator {
	

	public static ServicoRequest paraSalvar() {
		return ServicoRequest.builder()
				.barbeiroCpf(BarbeiroEntityCreator.paraSalvar().getCpf())
				.duracaoEmMinutos(60l)
				.preco(new BigDecimal("50"))
				.status(true)
				.tipo(ServicoTipoEnum.PLATINADO)
				.build();
	}
	
	public static ServicoRequest paraAtualizar() {
		return ServicoRequest.builder()
				.barbeiroCpf(BarbeiroEntityCreator.paraAtualizar().getCpf())
				.duracaoEmMinutos(30l)
				.preco(new BigDecimal("60"))
				.status(true)
				.tipo(ServicoTipoEnum.CORTE_ADULTO)
				.build();
	}
}
