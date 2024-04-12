package com.coima.madeireira.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.PastOrPresent;

import com.coima.madeireira.entities.Product;
import com.coima.madeireira.entities.Venda;

public class VendaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Double valorTotal;
	private Double valorEntrada;
	private Integer qtdItens;
	private Integer qtdVezes;
	private String formaPagamento;
	private String cpfCliente;
	private Long matriculaFuncionario;
	
	@PastOrPresent(message = "Data da venda não pode ser futura")
	private Instant dataVenda;
	
	private List<ProductDTO> produtos = new ArrayList<>();
	
	public VendaDTO() {
	}
	
	public VendaDTO(Long id, Double valorTotal, Double valorEntrada, Integer qtdItens, Integer qtdVezes,
			String formaPagamento, String cpfCliente, Long matriculaFuncionario, Instant dataVenda) {
		this.id = id;
		this.valorTotal = valorTotal;
		this.valorEntrada = valorEntrada;
		this.qtdItens = qtdItens;
		this.qtdVezes = qtdVezes;
		this.formaPagamento = formaPagamento;
		this.cpfCliente = cpfCliente;
		this.matriculaFuncionario = matriculaFuncionario;
		this.dataVenda = dataVenda;
	}
	
	public VendaDTO(Venda entity) {
		this.id = entity.getId();
		this.valorTotal = entity.getValorTotal();
		this.valorEntrada = entity.getValorEntrada();
		this.qtdItens = entity.getQtdItens();
		this.qtdVezes = entity.getQtsVezes();
		this.formaPagamento = entity.getFormaPagamento();
		this.cpfCliente = entity.getCliente().getCpf();
		this.matriculaFuncionario = entity.getFuncionario().getMatricula();
		this.dataVenda = entity.getDataVenda();
	}
	
	
	public VendaDTO(Venda entity, Set<Product> produtos) {
		this(entity);
		produtos.forEach(prod -> this.produtos.add(new ProductDTO(prod)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getQtdVezes() {
		return qtdVezes;
	}

	public void setQtdVezes(Integer qtdVezes) {
		this.qtdVezes = qtdVezes;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Long getMatriculaFuncionario() {
		return matriculaFuncionario;
	}

	public void setMatriculaFuncionario(Long matriculaFuncionario) {
		this.matriculaFuncionario = matriculaFuncionario;
	}

	public Instant getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Instant dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<ProductDTO> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List<ProductDTO> produtos) {
		this.produtos = produtos;
	}
}
