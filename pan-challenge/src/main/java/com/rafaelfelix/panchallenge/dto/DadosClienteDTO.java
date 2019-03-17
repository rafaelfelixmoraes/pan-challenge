package com.rafaelfelix.panchallenge.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DadosClienteDTO implements Serializable {
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

	@NotNull(message = "Preechimento Obrigatório")
	private Integer cidadeId;

	public DadosClienteDTO() {

	}

	public DadosClienteDTO(Integer clienteId, String logradouro, String numero, String complemeto, String bairro,
			String cep, String telefone1, String telefone2, String telefone3, Integer cidadeId) {
		this.clienteId = clienteId;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemeto = complemeto;
		this.bairro = bairro;
		this.cep = cep;
		this.cidadeId = cidadeId;
	}

	/**
	 * @return the clienteId
	 */
	public Integer getClienteId() {
		return clienteId;
	}

	/**
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemeto
	 */
	public String getComplemeto() {
		return complemeto;
	}

	/**
	 * @param complemeto the complemeto to set
	 */
	public void setComplemeto(String complemeto) {
		this.complemeto = complemeto;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the cidadeId
	 */
	public Integer getCidadeId() {
		return cidadeId;
	}

	/**
	 * @param cidadeId the cidadeId to set
	 */
	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

}
