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

import com.coima.madeireira.dto.FornecedorDTO;
import com.coima.madeireira.services.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedoresResource {

	@Autowired
	private FornecedorService service;
	
	@GetMapping
	public ResponseEntity<Page<FornecedorDTO>> findAll(Pageable pageable) {
		Page<FornecedorDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<FornecedorDTO> findById(@PathVariable String cnpj) {
		FornecedorDTO dto = service.findById(cnpj);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<FornecedorDTO> insert(@Valid @RequestBody FornecedorDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}")
				.buildAndExpand(dto.getCnpj()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{cnpj}")
	public ResponseEntity<FornecedorDTO> update(@PathVariable String cnpj, @Valid @RequestBody FornecedorDTO dto) {
		dto = service.update(cnpj, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{cnpj}")
	public ResponseEntity<Void> delete(@PathVariable String cnpj) {
		service.delete(cnpj);
		return ResponseEntity.noContent().build();
	}
} 
