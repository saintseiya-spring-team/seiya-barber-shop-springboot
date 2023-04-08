package br.com.seiya.barbershop.domain.ports;

import java.time.LocalTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.seiya.barbershop.domain.dtos.ConsultaComplexaRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoRequest;
import br.com.seiya.barbershop.domain.dtos.ServicoResponse;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;

public interface ServicoServicePort {
	
	public ServicoResponse cadastrar(ServicoRequest barbeiro);
	
	public ServicoResponse buscarPorId(Long id);
	
	public List<ServicoResponse> buscarPorNomeBarbeiro(String nome);
	
	public Page<ServicoResponse> paginar(Pageable pagima);
	
	public ServicoResponse atualizar(Long id, @Valid ServicoRequest dados);

	public void exclusaoLogica(Long id);

	public List<ServicoResponse> buscarPorTipo(ServicoTipoEnum tipo);

	List<ServicoResponse> buscarPorTipoEDisponbilidade(ConsultaComplexaRequest request);

		
}