package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Cargo;
import com.escolar.system.dtos.CargoDTO;
import com.escolar.system.repositories.CargoRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	public Cargo findById(Long id) {
		Optional<Cargo> objCar = repository.findById(id);
		return objCar.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Cargo.class.getName()));
	}

	public List<Cargo> findAll() {
		return repository.findAll();
	}

	public Cargo create(CargoDTO objDTO) {
		return repository.save(new Cargo(null, objDTO.getNome()));
	}

	public Cargo update(Long id, @Valid CargoDTO objDTO) {
		Cargo oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		Cargo obj = findById(id);
		if(obj.getFuncionarios().size() > 0) {
			throw new DataIntegratyViolationException("Cargo possui Funcionario não pode ser deletado!");
		}
		repository.deleteById(id);
		
	}

}
