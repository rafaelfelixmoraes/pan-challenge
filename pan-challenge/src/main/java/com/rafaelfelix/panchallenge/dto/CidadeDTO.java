package com.rafaelfelix.panchallenge.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;

public class CidadeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	@JsonAlias("microrregiao")
	private MicroRegiaoDTO microRegiao;
	
	public CidadeDTO() {
		
	}

	public CidadeDTO(Integer id, String nome, MicroRegiaoDTO microRegiao) {
		this.id = id;
		this.nome = nome;
		this.microRegiao = microRegiao;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the microRegiao
	 */
	public MicroRegiaoDTO getMicroRegiao() {
		return microRegiao;
	}

	/**
	 * @param microRegiao the microRegiao to set
	 */
	public void setMicroRegiao(MicroRegiaoDTO microRegiao) {
		this.microRegiao = microRegiao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeDTO other = (CidadeDTO) obj;
		return Objects.equals(id, other.id);
	}

}
