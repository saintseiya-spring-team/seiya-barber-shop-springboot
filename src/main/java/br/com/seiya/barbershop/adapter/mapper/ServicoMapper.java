package br.com.seiya.barbershop.adapter.mapper;


import java.time.Duration;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;

@Mapper(componentModel = "spring")
public abstract class ServicoMapper {
	
	public static final ServicoMapper INSTANCE = Mappers.getMapper(ServicoMapper.class);

	@Mapping(target = "status", constant = "true")
	public abstract ServicoEntity toServicoEntity(ServicoRequest ServicoRequest);

	public abstract ServicoResponse toServicoResponse(ServicoEntity ServicoEntity);


	
}
