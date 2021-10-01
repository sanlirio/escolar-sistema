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

import com.escolar.system.domain.ValorReceita;
import com.escolar.system.dtos.ValorReceitaDTO;
import com.escolar.system.services.ValorReceitaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/valorReceitas")
public class ValorReceitaResource {

	@Autowired
	private ValorReceitaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ValorReceitaDTO> findById(@PathVariable Long id) {
		ValorReceita objVRec = service.findById(id);
		ValorReceitaDTO objVRcDTO = new ValorReceitaDTO(objVRec);
		return ResponseEntity.ok().body(objVRcDTO);

	}

	@GetMapping
	public ResponseEntity<List<ValorReceitaDTO>> findAll() {
		List<ValorReceitaDTO> listDTO = service.findAll().stream().map(obj -> new ValorReceitaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ValorReceitaDTO> create(@Valid @RequestBody ValorReceitaDTO objDTO) {
		objDTO = new ValorReceitaDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ValorReceitaDTO> update(@PathVariable Long id, @Valid @RequestBody ValorReceitaDTO objDTO) {
		ValorReceitaDTO newObj = new ValorReceitaDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
