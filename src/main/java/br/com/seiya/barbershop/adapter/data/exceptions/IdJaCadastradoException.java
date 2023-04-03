package br.com.seiya.barbershop.adapter.data.exceptions;

import br.com.seiya.barbershop.adapter.data.entities.BarbeiroEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IdJaCadastradoException extends RuntimeException{

    public IdJaCadastradoException(BarbeiroEntity barbeiroEntity) {
        super("CPF "+ barbeiroEntity.getCpf() + " já está cadastrado.");
    }
}
