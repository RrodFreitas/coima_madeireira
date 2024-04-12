package com.coima.madeireira.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coima.madeireira.dto.FornecedorDTO;
import com.coima.madeireira.entities.Fornecedor;
import com.coima.madeireira.repositories.FornecedorRepository;
import com.coima.madeireira.services.exceptions.DatabaseException;
import com.coima.madeireira.services.exceptions.ResourceNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<FornecedorDTO> findAllPaged(Pageable pageable) {
		Page<Fornecedor> page = repository.findAll(pageable);
		return page.map(x -> new FornecedorDTO(x));
	}

	@Transactional(readOnly = true)
	public FornecedorDTO findById(String cnpj) {
		Optional<Fornecedor> obj = repository.findById(cnpj);
		Fornecedor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado"));
		return new FornecedorDTO(entity);
	}

	@Transactional
	public FornecedorDTO insert(FornecedorDTO dto) {
		Fornecedor entity = new Fornecedor();
		createFornecedorDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new FornecedorDTO(entity);
	}

	@Transactional
	public FornecedorDTO update(String cnpj, FornecedorDTO dto) {
		try {
			Optional<Fornecedor> obj = repository.findById(cnpj);
			Fornecedor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Fornecedor não encontrado"));
			updatecopyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new FornecedorDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("CPF não encontrado " + cnpj);
		}		
	}

	public void delete(String cpf) {
		try {
			repository.deleteById(cpf);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("CPF não encontrado " + cpf);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void createFornecedorDtoToEntity(FornecedorDTO dto, Fornecedor entity) {
		entity.setNome(dto.getName());
		entity.setCnpj(dto.getCnpj());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
	}	
	
	private void updatecopyDtoToEntity(FornecedorDTO dto, Fornecedor entity) {
		entity.setNome(dto.getName());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
	}
}
