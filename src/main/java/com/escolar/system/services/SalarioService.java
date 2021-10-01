package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Funcionario;
import com.escolar.system.domain.Salario;
import com.escolar.system.dtos.SalarioDTO;
import com.escolar.system.repositories.SalarioRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class SalarioService {

	@Autowired
	private SalarioRepository repository;

	@Autowired
	private FuncionarioService funcionarioService;

	public Salario findById(Long id) {
		Optional<Salario> objDes = repository.findById(id);
		return objDes.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Salario.class.getName()));
	}

	public List<Salario> findAll() {
		return repository.findAll();
	}

	public Salario create(SalarioDTO objDTO) {
		return fromDTO(objDTO);
	}

	private Salario fromDTO(SalarioDTO objDTO) {
		Salario newObj = new Salario();

		newObj.setId(objDTO.getId());
		newObj.setDataPagamento(objDTO.getDataPagamento());
		newObj.setValorPago(objDTO.getValorPago());
		newObj.setFuncionarioResp(objDTO.getFuncionarioResp());
		newObj.setObservacao(objDTO.getObservacao());

		Funcionario func = funcionarioService.findById(objDTO.getFuncionario());
		newObj.setFuncionario(func);

		return repository.save(newObj);

	}

	public Salario update(Long id, @Valid SalarioDTO objDTO) {
		Salario oldObj = findById(id);

		oldObj.setDataPagamento(objDTO.getDataPagamento());
		oldObj.setValorPago(objDTO.getValorPago());
		oldObj.setFuncionarioResp(objDTO.getFuncionarioResp());
		oldObj.setObservacao(objDTO.getObservacao());
		Funcionario funcU = funcionarioService.findById(objDTO.getFuncionario());
		oldObj.setFuncionario(funcU);
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		repository.deleteById(id);

	}

}
