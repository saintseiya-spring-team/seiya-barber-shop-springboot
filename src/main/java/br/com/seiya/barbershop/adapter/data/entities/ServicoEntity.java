package br.com.seiya.barbershop.adapter.data.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "servicos")
public class ServicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String servicoTipo;

    private BigDecimal preco;

    private LocalDateTime duracao;

    @ManyToMany(mappedBy = "servicos")
    private List<BarbeiroEntity> listaBarbeiro = new ArrayList<>();
}
