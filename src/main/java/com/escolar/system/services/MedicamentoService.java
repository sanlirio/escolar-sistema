package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Medicamento;
import com.escolar.system.repositories.MedicamentoRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class MedicamentoService {

	@Autowired
	private MedicamentoRepository repository;

	public Medicamento findById(Long id) {
		Optional<Medicamento> objMed = repository.findById(id);
		return objMed.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Medicamento.class.getName()));

	}

	public List<Medicamento> findAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		Medicamento obj = findById(id);
		if (obj.getAlunos().size() > 0) {
			throw new DataIntegratyViolationException("Medicamento possui Dados ligado a ele e não pode ser deletado!");
		}
		repository.deleteById(id);

	}

}
