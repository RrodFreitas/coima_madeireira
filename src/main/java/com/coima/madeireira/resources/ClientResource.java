package com.coima.madeireira.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.coima.madeireira.dto.ClienteDTO;
import com.coima.madeireira.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> findAll(Pageable pageable) {
		Page<ClienteDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{cpf}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable String cpf) {
		ClienteDTO dto = service.findById(cpf);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteDTO> insert(@Valid @RequestBody ClienteDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cpf}")
				.buildAndExpand(dto.getCpf()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{cpf}")
	public ResponseEntity<ClienteDTO> update(@PathVariable String cpf, @Valid @RequestBody ClienteDTO dto) {
		dto = service.update(cpf, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{cpf}")
	public ResponseEntity<Void> delete(@PathVariable String cpf) {
		service.delete(cpf);
		return ResponseEntity.noContent().build();
	}
} 
