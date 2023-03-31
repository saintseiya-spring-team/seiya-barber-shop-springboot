package br.com.seiya.barbershop.adapter.data.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;

public interface BarbeiroJpaRepository extends JpaRepository<BarbeiroEntity, Long>{

	@Query("SELECT b FROM BarbeiroEntity b WHERE b.id = :id AND b.ativo = true")
    Optional<BarbeiroEntity> findByIdQuandoEstaAtivo(@Param("id") Long id);
	
	@Query("SELECT b FROM BarbeiroEntity b WHERE b.ativo = true")
    Page<BarbeiroEntity> findAllQuandoEstaAtivo(Pageable pagima);
	
}
