package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Receita;
import com.escolar.system.dtos.ReceitaDTO;
import com.escolar.system.repositories.ReceitaRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository repository;

	public Receita findById(Long id) {
		Optional<Receita> objRec = repository.findById(id);
		return objRec.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Receita.class.getName()));
	}

	public List<Receita> findAll() {
		return repository.findAll();
	}

	public Receita create(ReceitaDTO objDTO) {
		return fromDTO(objDTO);
	}

	private Receita fromDTO(ReceitaDTO objDTO) {
		Receita newObj = new Receita();

		newObj.setId(objDTO.getId());
		newObj.setNome(objDTO.getNome());

		return repository.save(newObj);

	}

	public Receita update(Long id, @Valid ReceitaDTO objDTO) {
		Receita oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Receita obj = findById(id);
		if (obj.getValorReceitas().size() > 0) {
			throw new DataIntegratyViolationException("Receita possui Valores ligado a ele e não pode ser deletado!");
		}
		repository.deleteById(id);

	}
}
