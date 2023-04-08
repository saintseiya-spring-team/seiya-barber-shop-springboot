package br.com.seiya.barbershop.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.seiya.barbershop.adapter.mapper.AgendamentoMapper;
import br.com.seiya.barbershop.adapter.mapper.BarbeiroMapper;
import br.com.seiya.barbershop.adapter.mapper.ClienteMapper;
import br.com.seiya.barbershop.adapter.mapper.ServicoMapper;
import br.com.seiya.barbershop.domain.ports.AgendamentoRepositoryPort;
import br.com.seiya.barbershop.domain.ports.AgendamentoServicePort;
import br.com.seiya.barbershop.domain.ports.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.domain.ports.BarbeiroServicePort;
import br.com.seiya.barbershop.domain.ports.ClienteRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ClienteServicePort;
import br.com.seiya.barbershop.domain.ports.ServicoRepositoryPort;
import br.com.seiya.barbershop.domain.ports.ServicoServicePort;
import br.com.seiya.barbershop.domain.services.AgendamentoServiceImp;
import br.com.seiya.barbershop.domain.services.BarbeiroServiceImp;
import br.com.seiya.barbershop.domain.services.ClienteServiceImp;
import br.com.seiya.barbershop.domain.services.ServicoServiceImp;

@Configuration
public class BeanConfiguracao {
	
	@Bean
	BarbeiroServicePort barbeiroService(BarbeiroRepositoryPort barbeiroRepositoryPort,  BarbeiroMapper mapper) {
		return new BarbeiroServiceImp(barbeiroRepositoryPort, mapper);
	}
	
	@Bean
	ClienteServicePort clienteService(ClienteRepositoryPort clienteRepositoryPort, ClienteMapper mapper) {
		return new ClienteServiceImp(clienteRepositoryPort, mapper);
	}
	
	@Bean
	ServicoServicePort servicoService(ServicoRepositoryPort servicoRepositoryPort, BarbeiroRepositoryPort barbeiroRepositoryPort,ServicoMapper mapper) {
		return new ServicoServiceImp(servicoRepositoryPort, barbeiroRepositoryPort, mapper);
	}
	
	@Bean
	AgendamentoServicePort agendamentoService(
			AgendamentoRepositoryPort agendamentoRepositoryPort, 
			BarbeiroRepositoryPort barbeiroRepositoryPort, 
			ClienteRepositoryPort clienteRepositoryPort, 
			ServicoRepositoryPort servicoRepositoryPort, 
			AgendamentoMapper mapper) {
		return new AgendamentoServiceImp(agendamentoRepositoryPort,barbeiroRepositoryPort, clienteRepositoryPort, servicoRepositoryPort, mapper);
	}
	
	
}
