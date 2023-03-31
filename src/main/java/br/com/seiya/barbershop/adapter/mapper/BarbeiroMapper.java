package br.com.seiya.barbershop.adapter.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import br.com.seiya.barbershop.domain.dtos.BarbeiroRequest;
import br.com.seiya.barbershop.domain.dtos.BarbeiroResponse;

@Mapper(componentModel = "spring")
@Component
public abstract class BarbeiroMapper {
	
	public static final BarbeiroMapper INSTANCE = Mappers.getMapper(BarbeiroMapper.class);


	public abstract BarbeiroEntity toBarbeiroEntity(BarbeiroRequest barbeiroRequest);


	public abstract BarbeiroResponse toBarbeiroResponse(BarbeiroEntity barbeiroResponse);
	
}
