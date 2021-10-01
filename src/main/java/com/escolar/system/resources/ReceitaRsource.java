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

import com.escolar.system.domain.Receita;
import com.escolar.system.dtos.ReceitaDTO;
import com.escolar.system.services.ReceitaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/receitas")
public class ReceitaRsource {

	@Autowired
	private ReceitaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ReceitaDTO> findById(@PathVariable Long id) {
		Receita objRec = service.findById(id);
		ReceitaDTO objRecDTO = new ReceitaDTO(objRec);
		return ResponseEntity.ok().body(objRecDTO);
	}

	@GetMapping
	public ResponseEntity<List<ReceitaDTO>> findAll() {
		List<ReceitaDTO> listDTO = service.findAll().stream().map(obj -> new ReceitaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ReceitaDTO> create(@Valid @RequestBody ReceitaDTO objDTO) {

		objDTO = new ReceitaDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ReceitaDTO> update(@PathVariable Long id, @Valid @RequestBody ReceitaDTO objDTO) {
		ReceitaDTO newObj = new ReceitaDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
