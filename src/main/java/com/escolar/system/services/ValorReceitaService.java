package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Receita;
import com.escolar.system.domain.ValorReceita;
import com.escolar.system.domain.enums.FormaPagamento;
import com.escolar.system.dtos.ValorReceitaDTO;
import com.escolar.system.repositories.ValorReceitaRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class ValorReceitaService {

	@Autowired
	private ValorReceitaRepository repository;

	@Autowired
	private ReceitaService receitaService;

	public ValorReceita findById(Long id) {
		Optional<ValorReceita> objVRec = repository.findById(id);
		return objVRec.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + ValorReceita.class.getName()));

	}

	public List<ValorReceita> findAll() {
		return repository.findAll();
	}

	public ValorReceita create(ValorReceitaDTO objDTO) {
		return fromDTO(objDTO);
	}

	private ValorReceita fromDTO(ValorReceitaDTO objDTO) {
		ValorReceita newObj = new ValorReceita();

		newObj.setId(objDTO.getId());
		newObj.setDataRecebimento(objDTO.getDataRecebimento());
		newObj.setValorRecebido(objDTO.getValorRecebido());
		newObj.setValorDesconto(objDTO.getValorDesconto());
		newObj.setFormaPagamento(FormaPagamento.toEnum(objDTO.getFormaPagamento()));
		newObj.setColaboradorResp(objDTO.getColaboradorResp());
		newObj.setObservacao(objDTO.getObservacao());

		Receita rec = receitaService.findById(objDTO.getReceita());
		newObj.setReceita(rec);

		return repository.save(newObj);
	}

	public ValorReceita update(Long id, @Valid ValorReceitaDTO objDTO) {
		ValorReceita oldObj = findById(id);

		oldObj.setDataRecebimento(objDTO.getDataRecebimento());
		oldObj.setValorRecebido(objDTO.getValorRecebido());
		oldObj.setValorDesconto(objDTO.getValorDesconto());
		oldObj.setFormaPagamento(FormaPagamento.toEnum(objDTO.getFormaPagamento()));
		oldObj.setColaboradorResp(objDTO.getColaboradorResp());
		oldObj.setObservacao(objDTO.getObservacao());

		Receita recU = receitaService.findById(objDTO.getReceita());
		oldObj.setReceita(recU);

		return repository.save(oldObj);
	}

	public void delete(Long id) {

		repository.deleteById(id);

	}

}
