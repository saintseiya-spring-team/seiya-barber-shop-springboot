package br.com.seiya.barbershop.adapter.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.seiya.barbershop.adapter.data.entities.AgendamentoEntity;
import br.com.seiya.barbershop.domain.dtos.AgendamentoRequest;
import br.com.seiya.barbershop.domain.dtos.AgendamentoResponse;

@Mapper(componentModel = "spring")
public abstract class AgendamentoMapper {
	
	public static final AgendamentoMapper INSTANCE = Mappers.getMapper(AgendamentoMapper.class);

	@Mapping(target = "status", constant = "true")
	@Mapping(target = "pendente", constant = "true")
	public abstract AgendamentoEntity toAgendamentoEntity(AgendamentoRequest AgendamentoRequest);

	public abstract AgendamentoResponse toAgendamentoResponse(AgendamentoEntity AgendamentoEntity);


	
}
