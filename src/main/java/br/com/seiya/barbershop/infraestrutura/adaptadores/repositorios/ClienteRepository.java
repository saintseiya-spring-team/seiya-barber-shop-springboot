package br.com.seiya.barbershop.infraestrutura.adaptadores.repositorios;


import br.com.seiya.barbershop.dominio.Cliente;
import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import br.com.seiya.barbershop.dominio.portas.repositorios.ClienteRepositoryPort;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository implements ClienteRepositoryPort {

    @Autowired
    private SpringClienteRepository springRepository;


    @Override
    public Cliente salvar(ClienteDTO cliente) {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public Page<Cliente> buscarTodos(Pageable pagina) {
        return null;
    }
}
