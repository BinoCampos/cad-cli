package com.fcampos.cadcli.domain.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteTest {

	@Mock
	Cliente clienteMock;

	@Test
	void nomeDeClienteNaoDeveSerNulo() {

		when(clienteMock.getNome()).thenReturn("john");

		String nome = clienteMock.getNome();

		assertNotNull(nome);

	}

}
