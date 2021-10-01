package com.escolar.system.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Aluno;
import com.escolar.system.domain.Matricula;
import com.escolar.system.domain.Turma;
import com.escolar.system.domain.Turno;
import com.escolar.system.dtos.MatriculaDTO;
import com.escolar.system.repositories.MatriculaRepository;
import com.escolar.system.services.exceptions.ObjectNotFoundException;

@Service
public class MatriculaService {

	@Autowired
	private MatriculaRepository repository;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private TurnoService turnoService;

	@Autowired
	private AlunoService alunoService;

	public Matricula findById(Long id) {
		Optional<Matricula> objMat = repository.findById(id);
		return objMat.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id " + id + ", Tipo: " + Matricula.class.getName()));
	}

	public List<Matricula> findAll() {
		return repository.findAll();
	}

	public Matricula create(MatriculaDTO objDTO) {
		return fromDTO(objDTO);
	}

	private Matricula fromDTO(MatriculaDTO objDTO) {
		Matricula newObj = new Matricula();

		newObj.setId(objDTO.getId());
		newObj.setNumeroMat(objDTO.getNumeroMat());
		newObj.setValorMat(objDTO.getValorMat());
		newObj.setDataMat(objDTO.getDataMat());
		newObj.setDataEncerramento(objDTO.getDataEncerramento());
		newObj.setValorFardamento(objDTO.getValorFardamento());
		newObj.setValorMensalidade(objDTO.getValorMensalidade());
		newObj.setValorDesconto(objDTO.getValorDesconto());
		newObj.setDisciplinas(objDTO.getDisciplinas());

		Aluno alu = alunoService.findById(objDTO.getAluno());
		newObj.setAluno(alu);

		Turma turm = turmaService.findById(objDTO.getTurma());
		newObj.setTurma(turm);

		Turno turn = turnoService.findById(objDTO.getTurno());
		newObj.setTurno(turn);

		return repository.save(newObj);

	}

	public Matricula update(Long id, @Valid MatriculaDTO objDTO) {
		Matricula oldObj = findById(id);

		oldObj.setNumeroMat(objDTO.getNumeroMat());
		oldObj.setValorMat(objDTO.getValorMat());
		oldObj.setDataMat(objDTO.getDataMat());
		oldObj.setDataEncerramento(objDTO.getDataEncerramento());
		oldObj.setValorFardamento(objDTO.getValorFardamento());
		oldObj.setValorMensalidade(objDTO.getValorMensalidade());
		oldObj.setValorDesconto(objDTO.getValorDesconto());
		oldObj.setDisciplinas(objDTO.getDisciplinas());

		Aluno aluU = alunoService.findById(objDTO.getAluno());
		oldObj.setAluno(aluU);

		Turma turmU = turmaService.findById(objDTO.getTurma());
		oldObj.setTurma(turmU);

		Turno turnU = turnoService.findById(objDTO.getTurno());
		oldObj.setTurno(turnU);

		return repository.save(oldObj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
