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

import com.escolar.system.domain.Matricula;
import com.escolar.system.dtos.MatriculaDTO;
import com.escolar.system.services.MatriculaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/matriculas")
public class MatriculaResource {

	@Autowired
	private MatriculaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MatriculaDTO> findById(@PathVariable Long id) {
		Matricula objMat = service.findById(id);
		MatriculaDTO objMatDto = new MatriculaDTO(objMat);
		return ResponseEntity.ok().body(objMatDto);
	}

	@GetMapping
	public ResponseEntity<List<MatriculaDTO>> findAll() {
		List<MatriculaDTO> listDTO = service.findAll().stream().map(obj -> new MatriculaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<MatriculaDTO> create(@RequestBody MatriculaDTO objDTO) {
		Matricula newObj = service.create(objDTO);
		objDTO = new MatriculaDTO(service.create(objDTO));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MatriculaDTO> update(@PathVariable Long id, @Valid @RequestBody MatriculaDTO objDTO) {
		MatriculaDTO newObj = new MatriculaDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
