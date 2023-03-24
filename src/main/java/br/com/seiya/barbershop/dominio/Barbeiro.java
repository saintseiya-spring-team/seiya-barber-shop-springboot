package br.com.seiya.barbershop.dominio;

import br.com.seiya.barbershop.dominio.dtos.BarbeiroDTO;
import br.com.seiya.barbershop.infraestrutura.adaptadores.entidades.ServicoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Barbeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    @JoinTable(
            name = "barbeiros_servicos",
            joinColumns = @JoinColumn(name ="barbeiro_id"),
            inverseJoinColumns = @JoinColumn(name ="servico_id")
    )
    @ElementCollection(targetClass = ServicoEntity.class)
    private List<ServicoEntity> servicos = new ArrayList<>();


}
