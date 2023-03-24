package br.com.seiya.barbershop.dominio.adaptadores.service;

import br.com.seiya.barbershop.dominio.Cliente;
import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import br.com.seiya.barbershop.dominio.dtos.ClienteResponseDTO;
import br.com.seiya.barbershop.dominio.portas.interfaces.ClienteServicePort;
import br.com.seiya.barbershop.dominio.portas.repositorios.BarbeiroRepositoryPort;
import br.com.seiya.barbershop.dominio.portas.repositorios.ClienteRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class ClienteServiceImp implements ClienteServicePort {

    @Autowired
    private ClienteRepositoryPort repository;

    public ClienteServiceImp(ClienteRepositoryPort repository) {
        this.repository = repository;
    }
    @Override
    public Cliente cadastrar(ClienteDTO cliente) {
        return repository.salvar(cliente);
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    @Override
    public Page<ClienteResponseDTO> paginarBarbeiros(Pageable pagina) {
        return repository.buscarTodos(pagina).map(ClienteResponseDTO::new);
    }
}
