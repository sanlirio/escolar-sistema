package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.TipoAlergia;
import com.escolar.system.repositories.TipoAlergiaRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class TipoAlergiaService {

	@Autowired
	private TipoAlergiaRepository repository;

	public TipoAlergia findById(Long id) {
		Optional<TipoAlergia> objTipoA = repository.findById(id);
		return objTipoA.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + TipoAlergia.class.getName()));
	}
	
	public List<TipoAlergia> findAll() {
		return repository.findAll();
	}

}
