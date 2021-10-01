package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Turma;
import com.escolar.system.dtos.TurmaDTO;
import com.escolar.system.repositories.TurmaRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;

	public Turma findById(Long id) {
		Optional<Turma> objTurm = repository.findById(id);
		return objTurm.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Turma.class.getName()));
	}

	public List<Turma> findAll() {
		return repository.findAll();
	}

	public Turma create(TurmaDTO objDTO) {
		return repository.save(new Turma(null, objDTO.getNome(), objDTO.getCurso()));
	}

	public Turma update(Long id, @Valid TurmaDTO objDTO) {
		Turma oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		oldObj.setCurso(objDTO.getCurso());
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Turma obj = findById(id);
		if (obj.getFuncionarios().size() > 0 || obj.getMatriculas().size() > 0) {
			throw new DataIntegratyViolationException("Turma possui Dados ligado a ela e não pode ser deletado!");
		}
		repository.deleteById(id);

	}

}
