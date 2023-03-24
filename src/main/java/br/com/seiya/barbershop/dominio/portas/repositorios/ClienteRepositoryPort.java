package br.com.seiya.barbershop.dominio.portas.repositorios;

import br.com.seiya.barbershop.dominio.Cliente;
import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryPort{

    Cliente salvar(ClienteDTO barbeiro);

    Cliente buscarPorId(Long id);

    Page<Cliente> buscarTodos(Pageable pagina);
}
