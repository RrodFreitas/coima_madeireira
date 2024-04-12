package com.coima.madeireira.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.coima.madeireira.entities.Funcionario;

public class FuncionarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long matricula;
	
	@Size(min = 11, max = 11, message = "Deve ter 11 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String cpf;
	
	@Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@NotBlank(message = "Campo obrigatório")
	private String endereco;
	
	private String telefone;
	
	@NotBlank(message = "Campo obrigatório")
	private String email;
			
	public FuncionarioDTO() {
	}
	
	public FuncionarioDTO(Long matricula, String name, String endereco, String cpf, String telefone, String email) {
		this.matricula = matricula;
		this.name = name;
		this.endereco = endereco;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
	}

	public FuncionarioDTO(Funcionario entity) {
		this.matricula = entity.getMatricula();
		this.name = entity.getNome();
		this.endereco = entity.getEndereco();
		this.cpf = entity.getCpf();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
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
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
