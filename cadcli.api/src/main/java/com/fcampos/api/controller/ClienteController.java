package com.fcampos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fcampos.cadcli.domain.model.Cliente;
import com.fcampos.cadcli.domain.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = "Clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@ApiOperation(value = "Método para buscar a lista de clientes")
	@GetMapping
	public List<Cliente> listar(){
		return clienteRepository.findAll();
	}

	@ApiOperation(value = "Método para buscar um cliente pelo id")
	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long idCliente){

		return clienteRepository.findById(idCliente)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}

	@ApiOperation(value = "Método para adicionar um cliente")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	@ApiOperation(value = "Método para alterar dados de um cliente")
	@PutMapping("/{idCliente}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long idCliente, @RequestBody Cliente cliente){
		if(!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		cliente = clienteRepository.save(cliente);

		return ResponseEntity.ok(cliente);
	}

	@ApiOperation(value = "Método para apagar um cliente")
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> excluir(@PathVariable Long idCliente) {
		if(!clienteRepository.existsById(idCliente)) {
			return ResponseEntity.notFound().build();
		}

		clienteRepository.deleteById(idCliente);
		return ResponseEntity.noContent().build();
	}
}

