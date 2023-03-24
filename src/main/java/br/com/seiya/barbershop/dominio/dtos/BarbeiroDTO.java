package br.com.seiya.barbershop.dominio.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Servico;

public class BarbeiroDTO {

    private String nome;

    private String email;

    private String telefone;

    private List<Servico> servicos = new ArrayList<>();
}
