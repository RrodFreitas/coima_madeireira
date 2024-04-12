package com.coima.madeireira.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valorTotal;
	private Double valorEntrada;
	private Integer qtdItens;
	private Integer qtsVezes;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataVenda;
	
	private String formaPagamento;
	
	@ManyToOne
	@JoinColumn(name = "matricula")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name = "tb_venda_produto",
			joinColumns = @JoinColumn(name = "venda_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))
	Set<Product> products = new HashSet<>();
		
	public Venda () {
	}
	
	public Venda(Long id, Funcionario funcionario, Cliente cliente, Double valorTotal, Double valorEntrada,
			Integer qtdItens, Integer qtsVezes, String formaPagamento) {
		this.id = id;
		this.funcionario = funcionario;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.valorEntrada = valorEntrada;
		this.qtdItens = qtdItens;
		this.qtsVezes = qtsVezes;
		this.formaPagamento = formaPagamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Integer getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(Integer qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Integer getQtsVezes() {
		return qtsVezes;
	}

	public void setQtsVezes(Integer qtsVezes) {
		this.qtsVezes = qtsVezes;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		return Objects.equals(id, other.id);
	}
}
