package br.com.seiya.barbershop.dominio.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.BarbeiroEntity;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.ServicoEntity;

public class BarbeiroResponseDTO {

	public Long id;
	public String nome;
	public String email;
	public String telefone;
	public List<ServicoEntity> servicos = new ArrayList<>();

    public BarbeiroResponseDTO(BarbeiroEntity barbeiro) {
    	this.id = barbeiro.getId();
    	this.nome = barbeiro.getNome();
    	this.email = barbeiro.getEmail();
    	this.telefone = barbeiro.getTelefone();
    	this.servicos = barbeiro.getServicos();
    }
    
}
