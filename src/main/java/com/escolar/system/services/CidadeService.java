package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Cidade;
import com.escolar.system.domain.enums.Estado;
import com.escolar.system.dtos.CidadeDTO;
import com.escolar.system.repositories.CidadeRepository;
import com.escolar.system.services.exceptions.DataIntegratyViolationException;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public Cidade findById(Long id) {
		Optional<Cidade> objCid = repository.findById(id);
		return objCid.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Cidade.class.getName()));
	}

	public List<Cidade> findAll() {
		return repository.findAll();
	}

	public Cidade create(CidadeDTO objDTO) {
		return fromDTO(objDTO);
	}

	private Cidade fromDTO(CidadeDTO objDTO) {
		Cidade newObj = new Cidade();

		newObj.setId(objDTO.getId());
		newObj.setNome(objDTO.getNome());
		newObj.setEstado(Estado.toEnum(objDTO.getEstado()));

		return repository.save(newObj);
	}
	
	public Cidade update(Long id, @Valid CidadeDTO objDTO) {
		Cidade oldObj = findById(id);

		oldObj.setNome(objDTO.getNome());
		oldObj.setEstado(Estado.toEnum(objDTO.getEstado()));
         return repository.save(oldObj);
	}
	
	public void delete(Long id) {
		Cidade obj = findById(id);
		if(obj.getPessoa().size() > 0) {
			throw new DataIntegratyViolationException("Cidade possui Dados ligado a ele e não pode ser deletado!");
		}
		repository.deleteById(id);
		
	}

}
