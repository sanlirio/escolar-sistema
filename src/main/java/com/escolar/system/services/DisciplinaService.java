package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Disciplina;
import com.escolar.system.dtos.DisciplinaDTO;
import com.escolar.system.repositories.DisciplinaRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	public Disciplina findById(Long id) {
		Optional<Disciplina> objDis = disciplinaRepository.findById(id);
		return objDis.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Disciplina.class.getName()));
	}

	public List<Disciplina> findAll() {
		return disciplinaRepository.findAll();
	}

	public Disciplina create(DisciplinaDTO objDTO) {
		return disciplinaRepository.save(new Disciplina(null, objDTO.getNome()));
	}

	public Disciplina update(Long id, @Valid DisciplinaDTO objDTO) {
		Disciplina oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		return disciplinaRepository.save(oldObj);
	}

	public void delete(Long id) {
		Disciplina obj = findById(id);
		if (obj.getFuncionarios().size() > 0 || obj.getMatriculas().size() > 0) {
			throw new DataIntegratyViolationException("Disciplina possui Dados ligado a ela e não pode ser deletado!");
		}
		disciplinaRepository.deleteById(id);

	}

}
