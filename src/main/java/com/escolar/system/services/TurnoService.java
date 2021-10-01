package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Turno;
import com.escolar.system.dtos.TurnoDTO;
import com.escolar.system.repositories.TurnoRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class TurnoService {

	@Autowired
	private TurnoRepository repository;

	public Turno findById(Long id) {
		Optional<Turno> objTur = repository.findById(id);
		return objTur.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Turno.class.getName()));
	}

	public List<Turno> findAll() {
		return repository.findAll();
	}

	public Turno create(TurnoDTO objDTO) {
		return repository.save(new Turno(null, objDTO.getNome()));
	}

	public Turno update(Long id, @Valid TurnoDTO objDTO) {
		Turno oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Turno obj = findById(id);
		if (obj.getFuncionarios().size() > 0 || obj.getMatriculas().size() > 0) {
			throw new DataIntegratyViolationException("Cargo possui Funcionario não pode ser deletado!");
		}
		repository.deleteById(id);

	}
}
