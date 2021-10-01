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

import com.escolar.system.domain.Disciplina;
import com.escolar.system.dtos.DisciplinaDTO;
import com.escolar.system.services.DisciplinaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/disciplinas")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<DisciplinaDTO> findById(@PathVariable Long id) {
		Disciplina objDis = service.findById(id);
		DisciplinaDTO objDisDto = new DisciplinaDTO(objDis);
		return ResponseEntity.ok().body(objDisDto);
	}

	@GetMapping
	public ResponseEntity<List<DisciplinaDTO>> findAll() {
		List<DisciplinaDTO> listDTO = service.findAll().stream().map(obj -> new DisciplinaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<DisciplinaDTO> create(@RequestBody DisciplinaDTO objDTO) {
		Disciplina newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<DisciplinaDTO> update(@PathVariable Long id, @Valid @RequestBody DisciplinaDTO objDTO) {
		DisciplinaDTO newObj = new DisciplinaDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
