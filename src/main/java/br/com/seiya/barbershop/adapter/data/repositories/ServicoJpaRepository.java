package br.com.seiya.barbershop.adapter.data.repositories;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.seiya.barbershop.adapter.data.entities.ServicoEntity;
import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;

public interface ServicoJpaRepository extends JpaRepository<ServicoEntity, Long>{

	@Query("SELECT s FROM ServicoEntity s WHERE s.id = :id AND s.status = true")
    Optional<ServicoEntity> findByIdQuandoEstaAtivo(@Param("id") Long id);
	
	@Query("SELECT s FROM ServicoEntity s WHERE s.barbeiro.cpf = (SELECT b.cpf FROM BarbeiroEntity b WHERE b.nome = :nome) AND s.status = true")
	List<ServicoEntity> findByNomeBarbeiroQuandoEstativo(@Param("nome") String nome);
	
	@Query("SELECT s FROM ServicoEntity s WHERE s.status = true")
    Page<ServicoEntity> findAllQuandoEstaAtivo(Pageable pagima);
	
	@Query("SELECT s FROM ServicoEntity s WHERE s.tipo = :tipo AND s.status = true")
	List<ServicoEntity> findByTipoQuandoEstativo(ServicoTipoEnum tipo);
	
	@Query("SELECT s FROM ServicoEntity s "
			+ "WHERE s.tipo = :tipo "
			+ "AND s.barbeiro IN (SELECT b FROM BarbeiroEntity b WHERE CASE "
			+ "WHEN :diaDaSemana = 'domingo' THEN b.domingo "
			+ "WHEN :diaDaSemana = 'segunda' THEN b.segunda "
			+ "WHEN :diaDaSemana = 'terca' THEN b.terca "
			+ "WHEN :diaDaSemana = 'quarta' THEN b.quarta "
			+ "WHEN :diaDaSemana = 'quinta' THEN b.quinta "
			+ "WHEN :diaDaSemana = 'sexta' THEN b.sexta "
			+ "WHEN :diaDaSemana = 'sabado' THEN b.sabado "
			+ "END = true "
			+ "AND b.ativo = true "
			+ "AND b.inicioExpediente <= :horarioAtendimento AND b.finalExpediente >= :horarioAtendimento) "
			+ "AND s.status = true")
	List<ServicoEntity> findByDisponibilidadeETipoQuandoEstativo(
			@Param("tipo") ServicoTipoEnum tipo, 
	        @Param("diaDaSemana") String diaDaSemana, 
	        @Param("horarioAtendimento") LocalTime horarioAtendimento);
	
}
