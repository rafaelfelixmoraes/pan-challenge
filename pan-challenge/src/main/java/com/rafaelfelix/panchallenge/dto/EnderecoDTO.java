package com.rafaelfelix.panchallenge.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer clienteId;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private String logradouro;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private String numero;
	
	private String complemeto;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private String bairro;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private String cep;
	
	@NotEmpty(message = "Preechimento Obrigatório")
	private String telefone1;
	
	private String telefone2;
	private String telefone3;
	
	@NotNull(message = "Preechimento Obrigatório")
	private Integer cidadeId;

}
