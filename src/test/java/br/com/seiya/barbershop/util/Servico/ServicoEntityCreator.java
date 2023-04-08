package br.com.seiya.barbershop.util.Servico;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.util.Barbeiro.BarbeiroEntityCreator;

public class ServicoEntityCreator {
	

	public static ServicoEntity paraSalvar() {
		return ServicoEntity.builder()
				.id(1l)
				.status(true)
				.barbeiro(BarbeiroEntityCreator.paraSalvar())
				.duracaoEmMinutos(ServicoRequestCreator.paraSalvar().duracaoEmMinutos)
				.preco(ServicoRequestCreator.paraSalvar().preco)
				.tipo(ServicoRequestCreator.paraSalvar().tipo)
				.build();
	}
	
	public static ServicoEntity paraAtualizar() {
		return ServicoEntity.builder()
				.status(true)
				.barbeiro(BarbeiroEntityCreator.paraAtualizar())
				.duracaoEmMinutos(ServicoRequestCreator.paraAtualizar().duracaoEmMinutos)
				.preco(ServicoRequestCreator.paraAtualizar().preco)
				.tipo(ServicoRequestCreator.paraAtualizar().tipo)
				.build();
	}
}
