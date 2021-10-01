package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.TipoDeficiencia;
import com.escolar.system.repositories.TipoDeficienciaRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class TipoDeficienciaService {

	@Autowired
	private TipoDeficienciaRepository repository;

	public TipoDeficiencia findById(Long id) {
		Optional<TipoDeficiencia> objTipoD = repository.findById(id);
		return objTipoD.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + TipoDeficiencia.class.getName()));
	}
	
	public List<TipoDeficiencia> findAll() {
		return repository.findAll();
	}
}
