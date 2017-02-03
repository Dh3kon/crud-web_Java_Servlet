package br.edu.devmedia.crud.dto;

import java.io.Serializable;

public class PreferenciaMusicalDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPreferencia;
	private String descricao;
	public int getIdPreferencia() {
		return idPreferencia;
	}
	public void setIdPreferencia(int idPreferencia) {
		this.idPreferencia = idPreferencia;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
