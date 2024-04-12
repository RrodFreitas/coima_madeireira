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

import com.coima.madeireira.dto.ClienteDTO;
import com.coima.madeireira.entities.Cliente;
import com.coima.madeireira.repositories.ClientRepository;
import com.coima.madeireira.services.exceptions.DatabaseException;
import com.coima.madeireira.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<ClienteDTO> findAllPaged(Pageable pageable) {
		Page<Cliente> page = repository.findAll(pageable);
		return page.map(x -> new ClienteDTO(x));
	}

	@Transactional(readOnly = true)
	public ClienteDTO findById(String cpf) {
		Optional<Cliente> obj = repository.findById(cpf);
		Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO insert(ClienteDTO dto) {
		Cliente entity = new Cliente();
		createClientDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new ClienteDTO(entity);
	}

	@Transactional
	public ClienteDTO update(String cpf, ClienteDTO dto) {
		try {
			Optional<Cliente> obj = repository.findById(cpf);
			Cliente entity = obj.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
			updateClientDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ClienteDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("CPF não encontrado " + cpf);
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
	
	private void createClientDtoToEntity(ClienteDTO dto, Cliente entity) {
		entity.setNome(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setEndereco(dto.getEndereco());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
	}	
	
	private void updateClientDtoToEntity(ClienteDTO dto, Cliente entity) {
		entity.setNome(dto.getName());
		entity.setEndereco(dto.getEndereco());
		entity.setEmail(dto.getEmail());
		entity.setTelefone(dto.getTelefone());
	}	
}
