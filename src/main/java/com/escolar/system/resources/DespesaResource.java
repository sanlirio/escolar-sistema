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

import com.escolar.system.domain.Despesa;
import com.escolar.system.dtos.DespesaDTO;
import com.escolar.system.services.DespesaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/despesas")
public class DespesaResource {

	@Autowired
	private DespesaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<DespesaDTO> findById(@PathVariable Long id) {
		Despesa objDes = service.findById(id);
		DespesaDTO objDesDto = new DespesaDTO(objDes);
		return ResponseEntity.ok().body(objDesDto);

	}

	@GetMapping
	public ResponseEntity<List<DespesaDTO>> findAll() {
		List<DespesaDTO> listDTO = service.findAll().stream().map(obj -> new DespesaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<DespesaDTO> create(@Valid @RequestBody DespesaDTO objDTO) {
		objDTO = new DespesaDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<DespesaDTO> update(@PathVariable Long id, @Valid @RequestBody DespesaDTO objDTO) {
		DespesaDTO newObj = new DespesaDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
