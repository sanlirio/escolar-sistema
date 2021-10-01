package com.escolar.system.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.escolar.system.domain.Aluno;
import com.escolar.system.domain.Responsavel;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponsavelDTO implements Serializable {
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
	@NotEmpty(message = "O campo TELEFONE é requerido")
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
	private String grauParentesco;
	private String observacao;
	private Long cidade;

	@ManyToMany(mappedBy = "responsaveis")
	private List<Aluno> alunos = new ArrayList<>();

	public ResponsavelDTO() {
		super();

	}

	public ResponsavelDTO(Responsavel objResp) {
		super();

		this.id = objResp.getId();
		this.nome = objResp.getNome();
		this.mae = objResp.getMae();
		this.pai = objResp.getPai();
		this.dataNascimento = objResp.getDataNascimento();
		this.dataCadastro = objResp.getDataCadastro();
		this.logradouro = objResp.getLogradouro();
		this.complemento = objResp.getComplemento();
		this.numero = objResp.getNumero();
		this.bairro = objResp.getBairro();
		this.cep = objResp.getCep();
		this.nacionalidade = objResp.getNacionalidade();
		this.email = objResp.getEmail();
		this.telefone1 = objResp.getTelefone1();
		this.telefone2 = objResp.getTelefone2();
		this.rg = objResp.getRg();
		this.orgaoEmissor = objResp.getOrgaoEmissor();
		this.cpf = objResp.getCpf();
		this.religiao = objResp.getReligiao();
		this.sexo = objResp.getSexo().getCod();
		this.status = objResp.getStatus().getCod();
		this.estadoCivil = objResp.getEstadoCivil().getCod();
		this.grauParentesco = objResp.getGrauParentesco();
		this.observacao = objResp.getObservacao();
		this.cidade = objResp.getCidade().getId();
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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

	public Long getCidade() {
		return cidade;
	}

	public void setCidade(Long cidade) {
		this.cidade = cidade;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
