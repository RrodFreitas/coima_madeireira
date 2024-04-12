package com.coima.madeireira.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cnpj;
	
	private String nome;
	private String endereco;
	private String telefone;
	
	public Fornecedor() {
	}
	
	public Fornecedor(String cnpj, String nome, String endereco, String telefone, String email, Date dataNascimento) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
