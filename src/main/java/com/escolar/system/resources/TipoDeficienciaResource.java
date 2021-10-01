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

import com.escolar.system.domain.TipoDeficiencia;
import com.escolar.system.dtos.TipoDeficienciaDTO;
import com.escolar.system.services.TipoDeficienciaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/tipoDeficiencias")
public class TipoDeficienciaResource {

	@Autowired
	private TipoDeficienciaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TipoDeficienciaDTO> findById(@PathVariable Long id) {
		TipoDeficiencia objTipoD = service.findById(id);
		TipoDeficienciaDTO objTipoDDTO = new TipoDeficienciaDTO(objTipoD);
		return ResponseEntity.ok().body(objTipoDDTO);
	}

	@GetMapping
	public ResponseEntity<List<TipoDeficienciaDTO>> findAll() {
		List<TipoDeficienciaDTO> listDTO = service.findAll().stream().map(obj -> new TipoDeficienciaDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
}
