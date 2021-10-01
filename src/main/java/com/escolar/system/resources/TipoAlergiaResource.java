package com.escolar.system.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.system.domain.TipoAlergia;
import com.escolar.system.dtos.TipoAlergiaDTO;
import com.escolar.system.services.TipoAlergiaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tipoAlergias")
public class TipoAlergiaResource {

	@Autowired
	private TipoAlergiaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoAlergiaDTO> findById(@PathVariable Long id) {
		TipoAlergia objTipoA = service.findById(id);
		TipoAlergiaDTO objTipoADTO = new TipoAlergiaDTO(objTipoA);
		return ResponseEntity.ok().body(objTipoADTO);
	}

	@GetMapping
	public ResponseEntity<List<TipoAlergiaDTO>> findAll() {
		List<TipoAlergiaDTO> listDTO = service.findAll().stream().map(obj -> new TipoAlergiaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

}
