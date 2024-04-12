package com.coima.madeireira.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.coima.madeireira.entities.Fornecedor;

public class FornecedorDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@Size(min = 11, max = 14, message = "Deve ter 14 digitos")
	private String cnpj;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	private String endereco;
	
	private String telefone;

		
	public FornecedorDTO() {
	}
	
	public FornecedorDTO(String cnpj, String name, String endereco, String telefone) {
		this.cnpj = cnpj;
		this.name = name;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public FornecedorDTO(Fornecedor entity) {
		this.cnpj = entity.getCnpj();
		this.name = entity.getNome();
		this.endereco = entity.getEndereco();
		this.telefone = entity.getTelefone();
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
}
