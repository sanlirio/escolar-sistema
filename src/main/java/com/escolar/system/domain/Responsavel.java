package com.escolar.system.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.domain.enums.TipoSanguinio;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_responsavel")
public class Responsavel extends Pessoa {
	private static final long serialVersionUID = 1L;

	private String grauParentesco;
	private String observacao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "responsaveis")
	private List<Aluno> alunos = new ArrayList<>();

	public Responsavel() {
		super();

	}

	public Responsavel(Long id, String nome, String mae, String pai, LocalDate dataNascimento, LocalDate dataCadastro,
			String nacionalidade, String email, String telefone1, String telefone2, String rg, String orgaoEmissor,
			String cpf, String religiao, Sexo sexo, Status status, EstadoCivil estadoCivil, TipoSanguinio tipoSanguinio,
			Cidade cidade, String grauParentesco, String observacao) {
		super(id, nome, mae, pai, dataNascimento, dataCadastro, nacionalidade, email, telefone1, telefone2, rg,
				orgaoEmissor, cpf, religiao, sexo, status, estadoCivil, tipoSanguinio, cidade);

		this.grauParentesco = grauParentesco;
		this.observacao = observacao;
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
