package com.fcampos.cadcli.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "CLIENT")
@Data
public class Cliente {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false, length = 100, name = "NAME")
	private String nome;

	@NotBlank
	@Email
	@Size(max = 255)
	@Column(nullable = false, name = "EMAIL")
	private String email;

	@NotBlank
	@Size(max = 20)
	@Column(name = "PHONE", length = 20)
	private String telefone;

	@NotBlank
	@Size(max = 50)
	@Column(name = "PASSWORD", length = 50)
	private String senha;

}
