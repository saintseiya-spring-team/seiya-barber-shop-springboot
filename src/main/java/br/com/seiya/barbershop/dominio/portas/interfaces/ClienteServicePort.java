package br.com.seiya.barbershop.dominio.portas.interfaces;

import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;

public interface ClienteServicePort {
    public void cadastrar(ClienteDTO cliente);
}
