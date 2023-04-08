package br.com.seiya.barbershop.adapter.data.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.seiya.barbershop.domain.enums.ServicoTipoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "servicos")
public class ServicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ServicoTipoEnum tipo;

    private BigDecimal preco;

    private Long duracaoEmMinutos;
    
    private Boolean status;

    @ManyToOne(targetEntity = BarbeiroEntity.class)
    private BarbeiroEntity barbeiro;
}
