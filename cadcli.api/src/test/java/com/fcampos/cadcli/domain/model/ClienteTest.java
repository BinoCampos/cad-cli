package com.fcampos.cadcli.domain.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	@DisplayName("Nome não pode ser nulo")
	void nomeDeClienteNulo() {
		Cliente cliente = new Cliente();
		cliente.setNome(null);
		assertTrue(false);
	}

}
