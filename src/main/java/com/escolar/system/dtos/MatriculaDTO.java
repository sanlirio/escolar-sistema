package com.escolar.system.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.escolar.system.domain.Disciplina;
import com.escolar.system.domain.Matricula;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MatriculaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String numeroMat;
	private BigDecimal valorMat;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataMat;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataEncerramento;

	private BigDecimal valorFardamento;
	private BigDecimal valorMensalidade;
	private BigDecimal valorDesconto;

	private Long aluno;
	private Long turma;
	private Long turno;

	@ManyToMany(targetEntity = Disciplina.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Matricula_Disciplina", joinColumns = @JoinColumn(name = "matricula_id"), 
	inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	public MatriculaDTO() {
		super();

	}

	public MatriculaDTO(Matricula objMat) {
		super();
		this.id = objMat.getId();
		this.numeroMat = objMat.getNumeroMat();
		this.valorMat = objMat.getValorMat();
		this.dataMat = objMat.getDataMat();
		this.dataEncerramento = objMat.getDataEncerramento();
		this.valorFardamento = objMat.getValorFardamento();
		this.valorMensalidade = objMat.getValorMensalidade();
		this.valorDesconto = objMat.getValorDesconto();

		this.aluno = objMat.getAluno().getId();
		this.turma = objMat.getTurma().getId();
		this.turno = objMat.getTurno().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroMat() {
		return numeroMat;
	}

	public void setNumeroMat(String numeroMat) {
		this.numeroMat = numeroMat;
	}

	public BigDecimal getValorMat() {
		return valorMat;
	}

	public void setValorMat(BigDecimal valorMat) {
		this.valorMat = valorMat;
	}

	public LocalDate getDataMat() {
		return dataMat;
	}

	public void setDataMat(LocalDate dataMat) {
		this.dataMat = dataMat;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public BigDecimal getValorFardamento() {
		return valorFardamento;
	}

	public void setValorFardamento(BigDecimal valorFardamento) {
		this.valorFardamento = valorFardamento;
	}

	public BigDecimal getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(BigDecimal valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Long getAluno() {
		return aluno;
	}

	public void setAluno(Long aluno) {
		this.aluno = aluno;
	}

	public Long getTurma() {
		return turma;
	}

	public void setTurma(Long turma) {
		this.turma = turma;
	}

	public Long getTurno() {
		return turno;
	}

	public void setTurno(Long turno) {
		this.turno = turno;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
