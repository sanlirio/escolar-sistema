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

import com.escolar.system.domain.Cargo;
import com.escolar.system.dtos.CargoDTO;
import com.escolar.system.services.CargoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cargos")
public class CargoResource {

	@Autowired
	private CargoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CargoDTO> findById(@PathVariable Long id) {
		Cargo objCarg = service.findById(id);
		CargoDTO objCargDto = new CargoDTO(objCarg);
		return ResponseEntity.ok().body(objCargDto);
	}

	@GetMapping
	public ResponseEntity<List<CargoDTO>> findAll() {
		List<CargoDTO> listDTO = service.findAll().stream().map(obj -> new CargoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<CargoDTO> create(@Valid @RequestBody CargoDTO objDTO) {
		Cargo newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
	/*
	 * Atualiza um Cargo
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<CargoDTO> update(@PathVariable Long id, @Valid @RequestBody CargoDTO objDTO) {
		CargoDTO newObj = new CargoDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
