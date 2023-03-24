package br.com.seiya.barbershop.dominio;

import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {

    private Long id;
    private String email;
    private String telefone;
    private Boolean status;
}
