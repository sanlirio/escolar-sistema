package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Despesa;
import com.escolar.system.dtos.DespesaDTO;
import com.escolar.system.repositories.DespesaRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;

	public Despesa findById(Long id) {
		Optional<Despesa> objDes = repository.findById(id);
		return objDes.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Despesa.class.getName()));
	}

	public List<Despesa> findAll() {
		return repository.findAll();
	}

	public Despesa create(DespesaDTO objDTO) {
		return fromDTO(objDTO);
	}

	private Despesa fromDTO(DespesaDTO objDTO) {
		Despesa newObj = new Despesa();

		newObj.setId(objDTO.getId());
		newObj.setNome(objDTO.getNome());

		return repository.save(newObj);

	}

	public Despesa update(Long id, @Valid DespesaDTO objDTO) {
		Despesa oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		return repository.save(oldObj);
	}
	
	public void delete(Long id) {
		Despesa obj = findById(id);
		if(obj.getValoresDespesas().size() > 0) {
			throw new DataIntegratyViolationException("Despesa possui Valores de despesas ligado a ele e não pode ser deletado!");
		}
		repository.deleteById(id);
		
	}

}
