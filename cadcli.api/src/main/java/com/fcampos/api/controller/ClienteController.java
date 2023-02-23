package com.fcampos.api.controller;

import com.fcampos.cadcli.domain.model.Cliente;
import com.fcampos.cadcli.domain.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@Api(tags = "Clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @ApiOperation(value = "Método para buscar a lista de clientes")
    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @ApiOperation(value = "Método para buscar um cliente pelo id")
    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente> buscarCliente(@PathVariable Long idCliente) {

        return clienteRepository.findById(idCliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @ApiOperation(value = "Método para apagar um cliente")
    @DeleteMapping("/{idCliente}")
    public ResponseEntity<Void> excluir(@PathVariable Long idCliente) {
        if (!clienteRepository.existsById(idCliente)) {
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(idCliente);
        return ResponseEntity.noContent().build();
    }

}

