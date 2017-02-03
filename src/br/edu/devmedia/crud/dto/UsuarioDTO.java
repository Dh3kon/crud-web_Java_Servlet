package br.edu.devmedia.crud.dto;

import java.io.Serializable;

/*
 * DTO para dados de usuários
 */
public class UsuarioDTO implements Serializable{

	private Integer idUsuario;
	private String usuario;
	private String senha;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
