package br.com.seiya.barbershop.infraestrutura.adaptadores.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.Barbeiro;

public interface SpringBarbeiroRepository extends JpaRepository<Barbeiro, Long>{

	@Query("SELECT b FROM Barbeiro b WHERE b.id = :id AND b.ativo = true")
    Optional<Barbeiro> findByIdQuandoEstaAtivo(@Param("id") Long id);
	
	@Query("SELECT b FROM Barbeiro b WHERE b.ativo = true")
    Page<Barbeiro> findAllQuandoEstaAtivo(Pageable pagima);
	
}
