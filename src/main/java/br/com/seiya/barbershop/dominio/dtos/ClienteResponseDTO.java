package br.com.seiya.barbershop.dominio.dtos;

import br.com.seiya.barbershop.dominio.Cliente;

public class ClienteResponseDTO {
    public Long id;

    public String email;

    public String telefone;

    public Boolean status;

    public ClienteResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.status = cliente.getStatus();
    }
}
