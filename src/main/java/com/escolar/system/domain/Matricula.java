package com.escolar.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_matricula")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToOne
	//@MapsId
	private Aluno aluno;

	@JsonIgnore
	@ManyToMany(targetEntity = Disciplina.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Matricula_Disciplina", joinColumns = @JoinColumn(name = "matricula_id"), 
	inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;

	@ManyToOne
	@JoinColumn(name = "turno_id")
	private Turno turno;

	public Matricula() {

	}

	public Matricula(Long id, String numeroMat, BigDecimal valorMat, LocalDate dataMat, LocalDate dataEncerramento,
			BigDecimal valorFardamento, BigDecimal valorMensalidade, BigDecimal valorDesconto, Aluno aluno,
			Turma turma, Turno turno) {
		super();
		this.id = id;
		this.numeroMat = numeroMat;
		this.valorMat = valorMat;
		this.dataMat = dataMat;
		this.dataEncerramento = dataEncerramento;
		this.valorFardamento = valorFardamento;
		this.valorMensalidade = valorMensalidade;
		this.valorDesconto = valorDesconto;
        this.aluno = aluno;
		this.turma = turma;
		this.turno = turno;
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
