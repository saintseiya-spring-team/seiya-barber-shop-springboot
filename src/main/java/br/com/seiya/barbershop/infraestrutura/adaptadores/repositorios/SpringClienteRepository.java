package br.com.seiya.barbershop.infraestrutura.adaptadores.repositorios;


import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
