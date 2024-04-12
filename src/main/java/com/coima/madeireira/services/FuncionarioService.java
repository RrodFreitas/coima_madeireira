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

import com.coima.madeireira.dto.FuncionarioDTO;
import com.coima.madeireira.entities.Funcionario;
import com.coima.madeireira.repositories.FuncionarioRepository;
import com.coima.madeireira.services.exceptions.DatabaseException;
import com.coima.madeireira.services.exceptions.ResourceNotFoundException;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	@Transactional(readOnly = true)
	public Page<FuncionarioDTO> findAllPaged(Pageable pageable) {
		Page<Funcionario> page = repository.findAll(pageable);
		return page.map(x -> new FuncionarioDTO(x));
	}

	@Transactional(readOnly = true)
	public FuncionarioDTO findById(Long id) {
		Optional<Funcionario> obj = repository.findById(id);
		Funcionario entity = obj.orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
		return new FuncionarioDTO(entity);
	}

	@Transactional
	public FuncionarioDTO insert(FuncionarioDTO dto) {
		Funcionario entity = new Funcionario();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new FuncionarioDTO(entity);
	}

	@Transactional
	public FuncionarioDTO update(Long matricula, FuncionarioDTO dto) {
		try {
			Funcionario entity = repository.getOne(matricula);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new FuncionarioDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Matricula não encontrada " + matricula);
		}		
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(FuncionarioDTO dto, Funcionario entity) {
		entity.setNome(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setEndereco(dto.getEndereco());
		entity.setTelefone(dto.getTelefone());
		entity.setEmail(dto.getEmail());
	}	
}
