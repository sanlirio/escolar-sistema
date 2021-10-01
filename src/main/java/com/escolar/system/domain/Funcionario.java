package com.escolar.system.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.GrauInstrucao;
import com.escolar.system.domain.enums.PosGraduacao;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.domain.enums.TipoSanguinio;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAdmissao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDemissao;
	private String ctps;
	private String serieCtps;
	private String pis;
	private Integer grauInstrucao;
	private String tipoPosGraduacao;
	private Integer posGraduacao;

	@ManyToOne()
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;

	// @JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<Salario> salarios = new ArrayList<>();

	// @JsonIgnore
	@ManyToMany(targetEntity = Disciplina.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Funcionario_Disciplina", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(targetEntity = Turma.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Funcionario_Turma", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas = new ArrayList<>();

	// @JsonIgnore
	@ManyToMany(targetEntity = Turno.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Funcionario_Turno", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "turno_id"))
	private List<Turno> turnos = new ArrayList<>();

	public Funcionario() {
		super();

	}

	public Funcionario(Long id, String nome, String mae, String pai, LocalDate dataNascimento, LocalDate dataCadastro,
			String nacionalidade, String email, String telefone1, String telefone2, String rg, String orgaoEmissor,
			String cpf, String religiao, Sexo sexo, Status status, EstadoCivil estadoCivil, TipoSanguinio tipoSanguinio,
			Cidade cidade, LocalDate dataAdmissao, LocalDate dataDemissao, String ctps, String serieCtps, String pis,
			GrauInstrucao grauInstrucao, String tipoPosGraduacao, PosGraduacao posGraduacao, Cargo cargo) {
		super(id, nome, mae, pai, dataNascimento, dataCadastro, nacionalidade, email, telefone1, telefone2, rg,
				orgaoEmissor, cpf, religiao, sexo, status, estadoCivil, tipoSanguinio, cidade);
		this.dataAdmissao = dataAdmissao;
		this.dataDemissao = dataDemissao;
		this.ctps = ctps;
		this.serieCtps = serieCtps;
		this.pis = pis;
		this.grauInstrucao = grauInstrucao.getCod();
		this.tipoPosGraduacao = tipoPosGraduacao;
		this.posGraduacao = posGraduacao.getCod();
		this.cargo = cargo;

	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getSerieCtps() {
		return serieCtps;
	}

	public void setSerieCtps(String serieCtps) {
		this.serieCtps = serieCtps;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public GrauInstrucao getGrauInstrucao() {
		return GrauInstrucao.toEnum(this.grauInstrucao);
	}

	public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
		this.grauInstrucao = grauInstrucao.getCod();
	}

	public String getTipoPosGraduacao() {
		return tipoPosGraduacao;
	}

	public void setTipoPosGraduacao(String tipoPosGraduacao) {
		this.tipoPosGraduacao = tipoPosGraduacao;
	}

	public PosGraduacao getPosGraduacao() {
		return PosGraduacao.toEnum(this.posGraduacao);
	}

	public void setPosGraduacao(PosGraduacao posGraduacao) {
		this.posGraduacao = posGraduacao.getCod();
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<Salario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<Salario> salarios) {
		this.salarios = salarios;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}

}
