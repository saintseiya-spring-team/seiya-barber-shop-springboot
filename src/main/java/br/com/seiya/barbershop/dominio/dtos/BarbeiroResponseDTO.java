package br.com.seiya.barbershop.dominio.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Servico;

public class BarbeiroResponseDTO {


	public Long id;

	public String nome;

	public String email;

	public String telefone;

	public List<Servico> servicos = new ArrayList<>();

    public BarbeiroResponseDTO(Barbeiro barbeiro) {
    	this.id = barbeiro.getId();
    	this.nome = barbeiro.getNome();
    	this.email = barbeiro.getEmail();
    	this.telefone = barbeiro.getTelefone();
    	this.servicos = barbeiro.getServicos();
    }
    
}
