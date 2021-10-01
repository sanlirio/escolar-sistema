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

import com.escolar.system.domain.Responsavel;
import com.escolar.system.dtos.ResponsavelDTO;
import com.escolar.system.services.ResponsavelService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/responsaveis")
public class ResponsavelResource {

	@Autowired
	private ResponsavelService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponsavelDTO> findById(@PathVariable Long id) {
		Responsavel objResp = service.findById(id);
		ResponsavelDTO objRespDTO = new ResponsavelDTO(objResp);
		return ResponseEntity.ok().body(objRespDTO);
	}

	@GetMapping
	public ResponseEntity<List<ResponsavelDTO>> findAll() {
		List<ResponsavelDTO> listDTO = service.findAll().stream().map(obj -> new ResponsavelDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ResponsavelDTO> create(@Valid @RequestBody ResponsavelDTO objDTO) {
		objDTO = new ResponsavelDTO(service.create(objDTO));

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponsavelDTO> update(@PathVariable Long id, @Valid @RequestBody ResponsavelDTO objDTO) {
		ResponsavelDTO newObj = new ResponsavelDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
