package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Despesa;
import com.escolar.system.domain.ValorDespesa;
import com.escolar.system.dtos.ValorDespesaDTO;
import com.escolar.system.repositories.ValorDespesaRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class ValorDespesaService {

	@Autowired
	private ValorDespesaRepository repository;

	@Autowired
	private DespesaService despesaService;

	public ValorDespesa findById(Long id) {
		Optional<ValorDespesa> objDesp = repository.findById(id);
		return objDesp.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + ValorDespesa.class.getName()));
	}

	public List<ValorDespesa> findAll() {
		return repository.findAll();
	}

	public ValorDespesa create(ValorDespesaDTO objDTO) {
		return fromDTO(objDTO);
	}

	private ValorDespesa fromDTO(ValorDespesaDTO objDTO) {
		ValorDespesa newObj = new ValorDespesa();

		newObj.setId(objDTO.getId());
		newObj.setDataPagamento(objDTO.getDataPagamento());
		newObj.setValorPagamento(objDTO.getValorPagamento());
		newObj.setColaboradorResp(objDTO.getColaboradorResp());
		newObj.setObservacao(objDTO.getObservacao());

		Despesa desp = despesaService.findById(objDTO.getDespesa());
		newObj.setDespesa(desp);

		return repository.save(newObj);
	}

	public ValorDespesa update(Long id, @Valid ValorDespesaDTO objDTO) {
		ValorDespesa oldObj = findById(id);

		oldObj.setDataPagamento(objDTO.getDataPagamento());
		oldObj.setValorPagamento(objDTO.getValorPagamento());
		oldObj.setColaboradorResp(objDTO.getColaboradorResp());
		oldObj.setObservacao(objDTO.getObservacao());

		Despesa despU = despesaService.findById(objDTO.getDespesa());
		oldObj.setDespesa(despU);

		return repository.save(oldObj);
	}

	public void delete(Long id) {

		repository.deleteById(id);

	}
}
