package com.coima.madeireira.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coima.madeireira.dto.ProductDTO;
import com.coima.madeireira.dto.VendaDTO;
import com.coima.madeireira.entities.Product;
import com.coima.madeireira.entities.Venda;
import com.coima.madeireira.repositories.ProductRepository;
import com.coima.madeireira.repositories.VendaRepository;
import com.coima.madeireira.services.exceptions.ResourceNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public Page<VendaDTO> findAllPaged(Long produtoId, Pageable pageable) {
		List<Product> produtos = (produtoId == 0) ? null : Arrays.asList(productRepository.getOne(produtoId));
		Page<Venda> page = repository.find(produtos, pageable);
		repository.buscarVendasComProdutos(page.getContent());
		return page.map(x -> new VendaDTO(x, x.getProducts()));
	}

	@Transactional(readOnly = true)
	public VendaDTO findById(Long id) {
		Optional<Venda> obj = repository.findById(id);
		Venda entity = obj.orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada"));
		return new VendaDTO(entity, entity.getProducts());
	}

	@Transactional
	public VendaDTO insert(VendaDTO dto) {
		Venda entity = new Venda();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new VendaDTO(entity);
	}
	
	private void copyDtoToEntity(VendaDTO dto, Venda entity) {
		entity.setFormaPagamento(dto.getFormaPagamento());
		entity.setQtdItens(dto.getQtdItens());
		entity.setQtsVezes(dto.getQtdVezes());
		entity.setValorEntrada(dto.getValorEntrada());
		entity.setValorTotal(dto.getValorTotal());
		entity.setDataVenda(dto.getDataVenda());
		//entity.setCliente(dto.getCpfCliente());
		//entity.setFuncionario(dto.getMatriculaFuncionario());
		
		entity.getProducts().clear();
		for (ProductDTO prodDTO : dto.getProdutos()) {
			Product produto = productRepository.getOne(prodDTO.getId());
			entity.getProducts().add(produto);			
		}
	}	
}
