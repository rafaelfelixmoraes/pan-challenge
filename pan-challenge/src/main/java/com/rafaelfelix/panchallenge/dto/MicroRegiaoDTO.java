package com.rafaelfelix.panchallenge.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MicroRegiaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	@JsonAlias("mesorregiao")
	private MesoRegiaoDTO mesoRegiao;
	
	public MicroRegiaoDTO() {
		
	}

	public MicroRegiaoDTO(Integer id, String nome, MesoRegiaoDTO mesoRegiao) {
		this.id = id;
		this.nome = nome;
		this.mesoRegiao = mesoRegiao;
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
	 * @return the mesoRegiao
	 */
	public MesoRegiaoDTO getMesoRegiao() {
		return mesoRegiao;
	}

	/**
	 * @param mesoRegiao the mesoRegiao to set
	 */
	public void setMesoRegiao(MesoRegiaoDTO mesoRegiao) {
		this.mesoRegiao = mesoRegiao;
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
		MicroRegiaoDTO other = (MicroRegiaoDTO) obj;
		return Objects.equals(id, other.id);
	}

}
