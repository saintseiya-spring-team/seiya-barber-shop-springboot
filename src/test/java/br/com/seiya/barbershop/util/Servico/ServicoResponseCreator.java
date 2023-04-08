package br.com.seiya.barbershop.util.Servico;

import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
public class ServicoResponseCreator {
	

	public static ServicoResponse paraSalvar() {
		return ServicoResponse.builder()
				.id(ServicoEntityCreator.paraSalvar().getId())
				.status(ServicoEntityCreator.paraSalvar().getStatus())
				.barbeiro(ServicoEntityCreator.paraSalvar().getBarbeiro())
				.duracaoEmMinutos(ServicoEntityCreator.paraSalvar().getDuracaoEmMinutos())
				.preco(ServicoEntityCreator.paraSalvar().getPreco())
				.tipo(ServicoEntityCreator.paraSalvar().getTipo())
				.build();
	}
	
	public static ServicoResponse paraAtualizar() {
		return ServicoResponse.builder()
				.status(ServicoEntityCreator.paraAtualizar().getStatus())
				.barbeiro(ServicoEntityCreator.paraAtualizar().getBarbeiro())
				.duracaoEmMinutos(ServicoEntityCreator.paraAtualizar().getDuracaoEmMinutos())
				.preco(ServicoEntityCreator.paraAtualizar().getPreco())
				.tipo(ServicoEntityCreator.paraAtualizar().getTipo())
				.build();
	}
	
}
