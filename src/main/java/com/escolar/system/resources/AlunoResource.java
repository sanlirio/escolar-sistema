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

import com.escolar.system.domain.Aluno;
import com.escolar.system.dtos.AlunoDTO;
import com.escolar.system.services.AlunoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	@Autowired
	private AlunoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
		Aluno objAlu = service.findById(id);
		AlunoDTO objAluDTO = new AlunoDTO(objAlu);
		return ResponseEntity.ok().body(objAluDTO);

	}

	@GetMapping
	public ResponseEntity<List<AlunoDTO>> findAll() {
		List<AlunoDTO> listDTO = service.findAll().stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> create(@Valid @RequestBody AlunoDTO objDTO) {
		objDTO = new AlunoDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @Valid @RequestBody AlunoDTO objDTO) {
		AlunoDTO newObj = new AlunoDTO(service.update(id,objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
