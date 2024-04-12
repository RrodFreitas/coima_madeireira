package com.coima.madeireira.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.coima.madeireira.entities.Cliente;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Size(min = 11, max = 11, message = "Deve ter 11 digitos")
	private String cpf;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	private String endereco;
	
	private String telefone;
	
	@NotBlank(message = "Campo obrigatório")
	private String email;
		
	public ClienteDTO() {
	}
	
	public ClienteDTO( String cpf, String name, String endereco, String telefone, String email) {
		this.cpf = cpf;
		this.name = name;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public ClienteDTO(Cliente entity) {
		this.cpf = entity.getCpf();
		this.name = entity.getNome();
		this.endereco = entity.getEndereco();
		this.email = entity.getEmail();
		this.telefone = entity.getTelefone();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
