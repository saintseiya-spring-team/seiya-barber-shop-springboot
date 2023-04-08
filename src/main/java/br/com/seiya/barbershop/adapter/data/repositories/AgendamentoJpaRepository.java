package br.com.seiya.barbershop.adapter.data.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.seiya.barbershop.adapter.data.entities.AgendamentoEntity;

public interface AgendamentoJpaRepository extends JpaRepository<AgendamentoEntity, Long>{

	@Query("SELECT b FROM AgendamentoEntity b WHERE b.id = :id AND b.status = true")
    Optional<AgendamentoEntity> findByIdQuandoEstaAtivo(@Param("id") Long cpf);
	
	@Query("SELECT b FROM AgendamentoEntity b WHERE b.status = true")
    Page<AgendamentoEntity> findAllQuandoEstaAtivo(Pageable pagima);
	
}
