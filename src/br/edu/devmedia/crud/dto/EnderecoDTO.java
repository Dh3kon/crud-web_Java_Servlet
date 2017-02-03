package br.edu.devmedia.crud.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable{

	private int idEndereco;
	private String logradouro;
	private UfDTO uf;
	private CidadeDTO cidade;
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public UfDTO getUf() {
		return uf;
	}
	public void setUf(UfDTO uf) {
		this.uf = uf;
	}
	public CidadeDTO getCidade() {
		return cidade;
	}
	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}
	
	
}
