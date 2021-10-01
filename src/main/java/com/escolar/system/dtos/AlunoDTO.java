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

import com.escolar.system.domain.Aluno;
import com.escolar.system.domain.Medicamento;
import com.escolar.system.domain.Responsavel;
import com.escolar.system.domain.TipoAlergia;
import com.escolar.system.domain.TipoDeficiencia;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;
	@NotEmpty(message = "O campo NOME da mãe é requerido")
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
	private String cpf;
	private String religiao;
	private Integer sexo;
	private Integer status;
	private Integer estadoCivil;
	private Integer tipoSanguinio;

	private Integer deficienciaFisica;
	private Integer alergia;
	private Integer usaMedicamentos;
	private String observacao;
	private Long cidade;

	@ManyToMany(targetEntity = Responsavel.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_Responsavel", joinColumns = @JoinColumn(name = "aluno_id"), 
	inverseJoinColumns = @JoinColumn(name = "responsavel_id"))
	private List<Responsavel> responsaveis = new ArrayList<>();

	// @JsonIgnore
	@ManyToMany(targetEntity = TipoAlergia.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_TipoAlergia", joinColumns = @JoinColumn(name = "aluno_id"), 
	inverseJoinColumns = @JoinColumn(name = "tipoAlergia_id"))
	private List<TipoAlergia> tipoAlergias = new ArrayList<>();

	// @JsonIgnore
	@ManyToMany(targetEntity = TipoDeficiencia.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_TipoDeficiencia", joinColumns = @JoinColumn(name = "aluno_id"),
	inverseJoinColumns = @JoinColumn(name = "tipoDeficiencia_id"))
	private List<TipoDeficiencia> tipoDeficiencias = new ArrayList<>();

	// @JsonIgnore
	@ManyToMany(targetEntity = Medicamento.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_Medicamento", joinColumns = @JoinColumn(name = "aluno_id"),
	inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
	private List<Medicamento> medicamentos = new ArrayList<>();

	public AlunoDTO() {
		super();

	}

	public AlunoDTO(Aluno objAlu) {
		super();
		this.id = objAlu.getId();
		this.nome = objAlu.getNome();
		this.mae = objAlu.getMae();
		this.pai = objAlu.getPai();
		this.dataNascimento = objAlu.getDataNascimento();
		this.dataCadastro = objAlu.getDataCadastro();
		this.logradouro = objAlu.getLogradouro();
		this.complemento = objAlu.getComplemento();
		this.numero = objAlu.getNumero();
		this.bairro = objAlu.getBairro();
		this.cep = objAlu.getCep();
		this.nacionalidade = objAlu.getNacionalidade();
		this.email = objAlu.getEmail();
		this.telefone1 = objAlu.getTelefone1();
		this.telefone2 = objAlu.getTelefone2();
		this.rg = objAlu.getRg();
		this.orgaoEmissor = objAlu.getOrgaoEmissor();
		this.cpf = objAlu.getCpf();
		this.religiao = objAlu.getReligiao();
		this.sexo = objAlu.getSexo().getCod();
		this.status = objAlu.getStatus().getCod();
		this.estadoCivil = objAlu.getEstadoCivil().getCod();
		this.tipoSanguinio = objAlu.getTipoSanguinio().getCod();
		this.deficienciaFisica = objAlu.getDeficienciaFisica().getCod();
		this.alergia = objAlu.getAlergia().getCod();
		this.usaMedicamentos = objAlu.getUsaMedicamentos().getCod();
		this.observacao = objAlu.getObservacao();
		this.cidade = objAlu.getCidade().getId();
		

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

	public Integer getDeficienciaFisica() {
		return deficienciaFisica;
	}

	public void setDeficienciaFisica(Integer deficienciaFisica) {
		this.deficienciaFisica = deficienciaFisica;
	}

	public Integer getAlergia() {
		return alergia;
	}

	public void setAlergia(Integer alergia) {
		this.alergia = alergia;
	}

	public Integer getUsaMedicamentos() {
		return usaMedicamentos;
	}

	public void setUsaMedicamentos(Integer usaMedicamentos) {
		this.usaMedicamentos = usaMedicamentos;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<TipoAlergia> getTipoAlergias() {
		return tipoAlergias;
	}

	public void setTipoAlergias(List<TipoAlergia> tipoAlergias) {
		this.tipoAlergias = tipoAlergias;
	}

	public List<TipoDeficiencia> getTipoDeficiencias() {
		return tipoDeficiencias;
	}

	public void setTipoDeficiencias(List<TipoDeficiencia> tipoDeficiencias) {
		this.tipoDeficiencias = tipoDeficiencias;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
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

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

}
