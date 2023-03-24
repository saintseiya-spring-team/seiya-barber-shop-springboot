package br.com.seiya.barbershop.infraestrutura.adaptadores.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.BarbeiroEntity;

public interface SpringBarbeiroRepository extends JpaRepository<BarbeiroEntity, Long>{

}
