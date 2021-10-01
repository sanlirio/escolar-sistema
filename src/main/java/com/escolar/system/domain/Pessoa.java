package com.escolar.system.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CPF;

import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.domain.enums.TipoSanguinio;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_pessoa")
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
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
	private String cpf;
	private String religiao;
	private Integer sexo;
	private Integer status;
	private Integer estadoCivil;
	private Integer tipoSanguinio;

	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;

	public Pessoa() {
		this.setDataCadastro(LocalDate.now()); // Data automatica do sistema

	}

	public Pessoa(Long id, String nome, String mae, String pai, LocalDate dataNascimento, LocalDate dataCadastro,
			String nacionalidade, String email, String telefone1, String telefone2, String rg, String orgaoEmissor,
			String cpf, String religiao, Sexo sexo, Status status, EstadoCivil estadoCivil, TipoSanguinio tipoSanguinio,
			Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.mae = mae;
		this.pai = pai;
		this.dataNascimento = dataNascimento;
		this.setDataCadastro(LocalDate.now()); // Data automatica do sistema
		this.nacionalidade = nacionalidade;
		this.email = email;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.rg = rg;
		this.orgaoEmissor = orgaoEmissor;
		this.cpf = cpf;
		this.religiao = religiao;
		this.sexo = sexo.getCod();
		this.status = status.getCod();
		this.estadoCivil = estadoCivil.getCod();
		this.tipoSanguinio = tipoSanguinio.getCod();
		this.cidade = cidade;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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

	public Sexo getSexo() {
		return Sexo.toEnum(this.sexo);
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo.getCod();
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public EstadoCivil getEstadoCivil() {
		return EstadoCivil.toEnum(this.estadoCivil);
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil.getCod();
	}

	public TipoSanguinio getTipoSanguinio() {
		return TipoSanguinio.toEnum(this.tipoSanguinio);
	}

	public void setTipoSanguinio(TipoSanguinio tipoSanguinio) {
		this.tipoSanguinio = tipoSanguinio.getCod();
	}

	public Cidade getEndereco() {
		return cidade;
	}

	public void setEndereco(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
