package br.com.seiya.barbershop.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.seiya.barbershop.adapter.mapper.BarbeiroMapper;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import br.com.seiya.barbershop.domain.services.BarbeiroServiceImp;

@Configuration
public class BeanConfiguracao {
	
	@Bean
	BarbeiroServicePort barbeiroService(BarbeiroRepositoryPort barbeiroRepositoryPort, BarbeiroMapper mapper) {
		return new BarbeiroServiceImp(barbeiroRepositoryPort, mapper);
	}
	
	
}
