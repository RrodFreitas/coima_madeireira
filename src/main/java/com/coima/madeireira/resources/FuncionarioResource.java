package com.coima.madeireira.resources;

import java.net.URI;

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

import com.coima.madeireira.dto.FuncionarioDTO;
import com.coima.madeireira.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioResource {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<Page<FuncionarioDTO>> findAll(Pageable pageable) {
		Page<FuncionarioDTO> list = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{matricula}")
	public ResponseEntity<FuncionarioDTO> findById(@PathVariable Long id) {
		FuncionarioDTO funcionario = service.findById(id);
		return ResponseEntity.ok().body(funcionario);
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> insert(@RequestBody FuncionarioDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{matricula}")
				.buildAndExpand(dto.getMatricula()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{matricula}")
	public ResponseEntity<FuncionarioDTO> update(@PathVariable Long matricula, @RequestBody FuncionarioDTO dto){
		dto = service.update(matricula, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{matricula}")
	public ResponseEntity<Void> delete(@PathVariable Long matricula){
		service.delete(matricula);
		return ResponseEntity.noContent().build();
	}
}
