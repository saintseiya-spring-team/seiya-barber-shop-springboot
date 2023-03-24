package br.com.seiya.barbershop.aplicativo.adaptadores.controllers;

import br.com.seiya.barbershop.dominio.dtos.ClienteDTO;
import br.com.seiya.barbershop.dominio.portas.interfaces.ClienteServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/clientes")
public class ClienteController {

    private ClienteServicePort service;

    @GetMapping
    public ResponseEntity<ClienteDTO> cadastraCliente(@RequestBody ClienteDTO clienteDTO){
        service.cadastrar(clienteDTO);
        return ResponseEntity.ok(clienteDTO);
    }
}
