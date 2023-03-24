package br.com.seiya.barbershop.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.seiya.barbershop.dominio.adaptadores.service.BarbeiroServiceImp;
import br.com.seiya.barbershop.dominio.portas.interfaces.BarbeiroServicePort;
import br.com.seiya.barbershop.dominio.portas.repositories.BarbeiroRepositoryPort;

@Configuration
public class BeanConfiguracao {
	
	@Bean
	BarbeiroServicePort barbeiroService(BarbeiroRepositoryPort barbeiroRepositoryPort) {
		return new BarbeiroServiceImp(barbeiroRepositoryPort);
	}
}
