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

import com.escolar.system.domain.Mensalidade;
import com.escolar.system.dtos.MensalidadeDTO;
import com.escolar.system.services.MensalidadeService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/mensalidades")
public class MensalidadeResource {

	@Autowired
	private MensalidadeService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MensalidadeDTO> findById(@PathVariable Long id) {
		Mensalidade objMen = service.findById(id);
		MensalidadeDTO objMenDTO = new MensalidadeDTO(objMen);
		return ResponseEntity.ok().body(objMenDTO);

	}

	@GetMapping
	public ResponseEntity<List<MensalidadeDTO>> findAll() {
		List<MensalidadeDTO> listDTO = service.findAll().stream().map(obj -> new MensalidadeDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<MensalidadeDTO> create(@Valid @RequestBody MensalidadeDTO objDTO) {
		objDTO = new MensalidadeDTO(service.create(objDTO));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MensalidadeDTO> update(@PathVariable Long id, @Valid @RequestBody MensalidadeDTO objDTO) {
		MensalidadeDTO newObj = new MensalidadeDTO(service.update(id, objDTO));
		return ResponseEntity.ok().body(newObj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

}
