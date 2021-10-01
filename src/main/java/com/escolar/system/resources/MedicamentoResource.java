package com.escolar.system.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.escolar.system.domain.Medicamento;
import com.escolar.system.dtos.MedicamentoDTO;
import com.escolar.system.services.MedicamentoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/medicamentos")
public class MedicamentoResource {

	@Autowired
	private MedicamentoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<MedicamentoDTO> findById(@PathVariable Long id) {
		Medicamento objMed = service.findById(id);
		MedicamentoDTO objMedDto = new MedicamentoDTO(objMed);
		return ResponseEntity.ok().body(objMedDto);
	}

	@GetMapping
	public ResponseEntity<List<MedicamentoDTO>> findAll() {
		List<MedicamentoDTO> listDTO = service.findAll().stream().map(obj -> new MedicamentoDTO(obj))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}

}
