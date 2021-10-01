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

import com.escolar.system.domain.ValorDespesa;
import com.escolar.system.dtos.ValorDespesaDTO;
import com.escolar.system.services.ValorDespesaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "valorDespesas")
public class ValorDespesaResource {

	@Autowired
	private ValorDespesaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ValorDespesaDTO> findById(@PathVariable Long id) {
		ValorDespesa objVDesp = service.findById(id);
		ValorDespesaDTO objVDesDTO = new ValorDespesaDTO(objVDesp);
		return ResponseEntity.ok().body(objVDesDTO);
	}

	@GetMapping
	public ResponseEntity<List<ValorDespesaDTO>> findAll() {
		List<ValorDespesaDTO> listDTO = service.findAll().stream().map(obj -> new ValorDespesaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ValorDespesaDTO> create(@Valid @RequestBody ValorDespesaDTO objDTO) {
		objDTO = new ValorDespesaDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ValorDespesaDTO> update(@PathVariable Long id, @Valid @RequestBody ValorDespesaDTO objDTO) {
		ValorDespesaDTO newObj = new ValorDespesaDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
