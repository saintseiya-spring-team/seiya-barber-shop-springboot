package br.com.seiya.barbershop.adapter.data.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.util.BarbeiroEntityCreator;

@DataJpaTest
@DisplayName("Testes para BarbeiroJpaRepositoryTest.")
class BarbeiroJpaRepositoryTest {
	
	@Autowired
	private BarbeiroJpaRepository jpaRepository;
	
	@Test
	@DisplayName("Busca de barbeiros pelo id, quando estão ativos.")
	void buscarBarbeiroPorId() {
		// cenario
		BarbeiroEntity entity = BarbeiroEntityCreator.paraSalvar();
		//acao
		jpaRepository.save(entity);
		Optional<BarbeiroEntity> retorno = jpaRepository.findByIdQuandoEstaAtivo(entity.getCpf());

		// verificação
		assertThat(retorno.get()).isEqualTo(entity);
	}

}
