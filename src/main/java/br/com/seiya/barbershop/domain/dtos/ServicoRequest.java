package br.com.seiya.barbershop.domain.dtos;

import java.math.BigDecimal;
import java.time.Duration;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import lombok.Builder;

@Builder
public class ServicoRequest {
	@NotNull
    public ServicoTipoEnum tipo;
	@NotNull
    public BigDecimal preco;
	@NotNull
    public Long duracaoEmMinutos;
    
    public Boolean status;
    @NotNull
    public String barbeiroCpf;
	
}
