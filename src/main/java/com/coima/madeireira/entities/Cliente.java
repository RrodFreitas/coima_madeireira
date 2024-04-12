package com.coima.madeireira.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tb_client")
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String cpf;
	
	private String nome;
	private String endereco;
	private String telefone;
	
	@Column(unique = true)
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	private List<Venda> compras = new ArrayList<>();
	
	public Cliente() {
	}
	
	public Cliente(String cpf, String nome, String endereco, String telefone, String email) {
		this.cpf = cpf;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Venda> getCompras() {
		return compras;
	}
}
