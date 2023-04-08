package br.com.seiya.barbershop.adapter.data.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.seiya.barbershop.adapter.data.entities.ClienteEntity;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, String>{

	@Query("SELECT c FROM ClienteEntity c WHERE c.id = :id AND c.status = true")
    Optional<ClienteEntity> findByIdQuandoEstaAtivo(@Param("id") String cpf);
	
	@Query("SELECT c FROM ClienteEntity c WHERE c.status = true")
    Page<ClienteEntity> findAllQuandoEstaAtivo(Pageable pagima);
	
}
