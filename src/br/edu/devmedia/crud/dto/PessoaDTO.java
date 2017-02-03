package br.edu.devmedia.crud.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PessoaDTO implements Serializable{

	private int idPessoa;
	private String nome;
	private String cpf;
	private String dtNasc;
	private char sexo;
	private List<PreferenciaMusicalDTO> preferencias;
	private String miniBio;
	private EnderecoDTO endereco;

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtNasc() {
		return dtNasc;
	}

	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public List<PreferenciaMusicalDTO> getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(List<PreferenciaMusicalDTO> preferencias) {
		this.preferencias = preferencias;
	}

	public String getMiniBio() {
		return miniBio;
	}

	public void setMiniBio(String miniBio) {
		this.miniBio = miniBio;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
