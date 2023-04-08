package br.com.seiya.barbershop.adapter.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;
import br.com.seiya.barbershop.domain.dtos.ClienteRequest;
import br.com.seiya.barbershop.domain.dtos.ClienteResponse;

@Mapper(componentModel = "spring")
public abstract class ClienteMapper {
	
	public static final ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);

	@Mapping(target = "status", constant = "true")
	public abstract ClienteEntity toClienteEntity(ClienteRequest clienteRequest);


	public abstract ClienteResponse toClienteResponse(ClienteEntity clienteResponse);


	
}
