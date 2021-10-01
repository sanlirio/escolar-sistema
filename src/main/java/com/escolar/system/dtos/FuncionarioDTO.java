package com.escolar.system.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.escolar.system.domain.Disciplina;
import com.escolar.system.domain.Funcionario;
import com.escolar.system.domain.Turma;
import com.escolar.system.domain.Turno;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;
	private String mae;
	private String pai;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;

	private String logradouro;
	private String complemento;
	private String numero;
	private String bairro;
	private String cep;

	private String nacionalidade;
	private String email;
	private String telefone1;
	private String telefone2;
	private String rg;
	private String orgaoEmissor;
	@CPF
	@NotEmpty(message = "O campo CPF é requerido")
	private String cpf;
	private String religiao;
	private Integer sexo;
	private Integer status;
	private Integer estadoCivil;
	private Integer tipoSanguinio;
	private Long cidade;

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

	private Long cargo;

	@ManyToMany(targetEntity = Disciplina.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Funcionario_Disciplina", joinColumns = @JoinColumn(name = "funcionario_id"), 
	inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
	private List<Disciplina> disciplinas = new ArrayList<>();

	@ManyToMany(targetEntity = Turno.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Funcionario_Turno", joinColumns = @JoinColumn(name = "funcionario_id"), 
	inverseJoinColumns = @JoinColumn(name = "turno_id"))
	private List<Turno> turnos = new ArrayList<>();
	
	@ManyToMany(targetEntity = Turma.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Funcionario_Turma", joinColumns = @JoinColumn(name = "funcionario_id"), 
	inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas = new ArrayList<>();

	public FuncionarioDTO() {
		super();

	}

	public FuncionarioDTO(Funcionario objFunc) {
		super();

		this.id = objFunc.getId();
		this.nome = objFunc.getNome();
		this.mae = objFunc.getMae();
		this.pai = objFunc.getPai();
		this.dataNascimento = objFunc.getDataNascimento();
		this.dataCadastro = objFunc.getDataCadastro();
		this.logradouro = objFunc.getLogradouro();
		this.complemento = objFunc.getComplemento();
		this.numero = objFunc.getNumero();
		this.bairro = objFunc.getBairro();
		this.cep = objFunc.getCep();
		this.nacionalidade = objFunc.getNacionalidade();
		this.email = objFunc.getEmail();
		this.telefone1 = objFunc.getTelefone1();
		this.telefone2 = objFunc.getTelefone2();
		this.rg = objFunc.getRg();
		this.orgaoEmissor = objFunc.getOrgaoEmissor();
		this.cpf = objFunc.getCpf();
		this.religiao = objFunc.getReligiao();
		this.sexo = objFunc.getSexo().getCod();
		this.status = objFunc.getStatus().getCod();
		this.estadoCivil = objFunc.getEstadoCivil().getCod();
		this.tipoSanguinio = objFunc.getTipoSanguinio().getCod();
		this.cidade = objFunc.getCidade().getId();
		this.dataAdmissao = objFunc.getDataAdmissao();
		this.dataDemissao = objFunc.getDataDemissao();
		this.ctps = objFunc.getCtps();
		this.serieCtps = objFunc.getSerieCtps();
		this.pis = objFunc.getPis();
		this.grauInstrucao = objFunc.getGrauInstrucao().getCod();
		this.tipoPosGraduacao = objFunc.getTipoPosGraduacao();
		this.posGraduacao = objFunc.getPosGraduacao().getCod();
		this.cargo = objFunc.getCargo().getId();

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMae() {
		return mae;
	}

	public void setMae(String mae) {
		this.mae = mae;
	}

	public String getPai() {
		return pai;
	}

	public void setPai(String pai) {
		this.pai = pai;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}

	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(Integer estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Integer getTipoSanguinio() {
		return tipoSanguinio;
	}

	public void setTipoSanguinio(Integer tipoSanguinio) {
		this.tipoSanguinio = tipoSanguinio;
	}

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
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

	public Integer getGrauInstrucao() {
		return grauInstrucao;
	}

	public void setGrauInstrucao(Integer grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}

	public String getTipoPosGraduacao() {
		return tipoPosGraduacao;
	}

	public void setTipoPosGraduacao(String tipoPosGraduacao) {
		this.tipoPosGraduacao = tipoPosGraduacao;
	}

	public Integer getPosGraduacao() {
		return posGraduacao;
	}

	public void setPosGraduacao(Integer posGraduacao) {
		this.posGraduacao = posGraduacao;
	}

	public Long getCargo() {
		return cargo;
	}

	public void setCargo(Long cargo) {
		this.cargo = cargo;
	}

	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
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

}
