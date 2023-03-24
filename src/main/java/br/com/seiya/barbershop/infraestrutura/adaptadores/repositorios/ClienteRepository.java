package br.com.seiya.barbershop.infraestrutura.adaptadores.repositorios;


import br.com.seiya.barbershop.dominio.Cliente;
import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import br.com.seiya.barbershop.dominio.portas.repositorios.ClienteRepositoryPort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepository implements ClienteRepositoryPort {


    @Override
    public Cliente salvar(ClienteDTO barbeiro) {
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
