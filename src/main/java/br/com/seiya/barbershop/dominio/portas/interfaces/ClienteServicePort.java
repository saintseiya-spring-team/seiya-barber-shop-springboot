package br.com.seiya.barbershop.dominio.portas.interfaces;

import br.com.seiya.barbershop.dominio.Cliente;
import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import br.com.seiya.barbershop.dominio.dtos.ClienteResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteServicePort {
    public Cliente cadastrar(ClienteDTO cliente);
    public Cliente buscarPorId(Long id);
    public Page<ClienteResponseDTO> paginarBarbeiros(Pageable pagina);
}
