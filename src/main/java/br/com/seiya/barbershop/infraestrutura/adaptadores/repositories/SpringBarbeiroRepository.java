package br.com.seiya.barbershop.infraestrutura.adaptadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public interface SpringBarbeiroRepository extends JpaRepository<Barbeiro, Long>{

}
