package com.escolar.system.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escolar.system.domain.Salario;
import com.escolar.system.dtos.SalarioDTO;
import com.escolar.system.services.SalarioService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/salarios")
public class SalarioResource {

	@Autowired
	private SalarioService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<SalarioDTO> findById(@PathVariable Long id) {
		Salario objDes = service.findById(id);
		SalarioDTO objDesDto = new SalarioDTO(objDes);
		return ResponseEntity.ok().body(objDesDto);

	}

	@GetMapping
	public ResponseEntity<List<SalarioDTO>> findAll() {
		List<SalarioDTO> listDTO = service.findAll().stream().map(obj -> new SalarioDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<SalarioDTO> create(@Valid @RequestBody SalarioDTO objDTO) {

		objDTO = new SalarioDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SalarioDTO> update(@PathVariable Long id, @Valid @RequestBody SalarioDTO objDTO) {
		SalarioDTO newObj = new SalarioDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
