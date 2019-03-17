package com.rafaelfelix.panchallenge.dto;

import java.io.Serializable;
import java.util.Objects;

public class EstadoDTO implements Serializable, Comparable<EstadoDTO> {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String sigla;
	private String nome;
	private RegiaoDTO regiao;
	
	public EstadoDTO() {
		
	}

	public EstadoDTO(Integer id, String sigla, String nome, RegiaoDTO regiao) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.regiao = regiao;
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
	 * @return the sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * @param sigla the sigla to set
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
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
	 * @return the regiao
	 */
	public RegiaoDTO getRegiao() {
		return regiao;
	}

	/**
	 * @param regiao the regiao to set
	 */
	public void setRegiao(RegiaoDTO regiao) {
		this.regiao = regiao;
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
		EstadoDTO other = (EstadoDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int compareTo(EstadoDTO o) {
		return this.nome.compareToIgnoreCase(o.getNome());
	}
	

}
