package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Aluno;
import com.escolar.system.domain.Mensalidade;
import com.escolar.system.domain.enums.FormaPagamento;
import com.escolar.system.dtos.MensalidadeDTO;
import com.escolar.system.repositories.MensalidadeRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class MensalidadeService {

	@Autowired
	private MensalidadeRepository repository;

	private AlunoService alunoService;

	public Mensalidade findById(Long id) {
		Optional<Mensalidade> objVRec = repository.findById(id);
		return objVRec.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Mensalidade.class.getName()));

	}

	public List<Mensalidade> findAll() {
		return repository.findAll();
	}

	public Mensalidade create(MensalidadeDTO objDTO) {
		return fromDTO(objDTO);
	}

	private Mensalidade fromDTO(MensalidadeDTO objDTO) {
		Mensalidade newObj = new Mensalidade();

		newObj.setId(objDTO.getId());
		newObj.setDataPagamento(objDTO.getDataPagamento());
		newObj.setValorPago(objDTO.getValorPago());
		newObj.setValorDesconto(objDTO.getValorDesconto());
		newObj.setFormaPagamento(FormaPagamento.toEnum(objDTO.getFormaPagamento()));
		newObj.setColaboradorResp(objDTO.getColaboradorResp());
		newObj.setObservacao(objDTO.getObservacao());

		Aluno alu = alunoService.findById(objDTO.getAluno());
		newObj.setAluno(alu);

		return repository.save(newObj);

	}

	public Mensalidade update(Long id, @Valid MensalidadeDTO objDTO) {
		Mensalidade oldObj = findById(id);

		oldObj.setDataPagamento(objDTO.getDataPagamento());
		oldObj.setValorPago(objDTO.getValorPago());
		oldObj.setValorDesconto(objDTO.getValorDesconto());
		oldObj.setFormaPagamento(FormaPagamento.toEnum(objDTO.getFormaPagamento()));
		oldObj.setColaboradorResp(objDTO.getColaboradorResp());
		oldObj.setObservacao(objDTO.getObservacao());

		Aluno aluU = alunoService.findById(objDTO.getAluno());
		oldObj.setAluno(aluU);

		return repository.save(oldObj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
