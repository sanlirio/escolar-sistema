
package com.escolar.system.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.escolar.system.domain.enums.Alergia;
import com.escolar.system.domain.enums.DeficienciaFisica;
import com.escolar.system.domain.enums.EstadoCivil;
import com.escolar.system.domain.enums.Sexo;
import com.escolar.system.domain.enums.Status;
import com.escolar.system.domain.enums.TipoSanguinio;
import com.escolar.system.domain.enums.UsaMedicamentos;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_aluno")
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;

	private Integer deficienciaFisica;
	private Integer alergia;
	private Integer usaMedicamentos;
	private String observacao;

	@OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
	private Matricula matricula;

	@OneToMany(mappedBy = "aluno")
	private List<Mensalidade> mensalidades = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(targetEntity = Responsavel.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_Responsavel", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "responsavel_id"))
	private List<Responsavel> responsaveis = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(targetEntity = TipoAlergia.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_TipoAlergia", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "tipoAlergia_id"))
	private List<TipoAlergia> tipoAlergias = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(targetEntity = TipoDeficiencia.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_TipoDeficiencia", joinColumns = @JoinColumn(name = "aluno_id"), inverseJoinColumns = @JoinColumn(name = "tipoDeficiencia_id"))
	private List<TipoDeficiencia> tipoDeficiencias = new ArrayList<>();

	@JsonIgnore
	@ManyToMany(targetEntity = Medicamento.class, cascade = CascadeType.ALL)
	@JoinTable(name = "Aluno_Medicamento", joinColumns = @JoinColumn(name = "aluno_id"), 
	inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
	private List<Medicamento> medicamentos = new ArrayList<>();

	public Aluno() {
		super();

	}

	public Aluno(Long id, String nome, String mae, String pai, LocalDate dataNascimento, LocalDate dataCadastro,
			String nacionalidade, String email, String telefone1, String telefone2, String rg, String orgaoEmissor,
			String cpf, String religiao, Sexo sexo, Status status, EstadoCivil estadoCivil, TipoSanguinio tipoSanguinio,
			Cidade cidade, DeficienciaFisica deficienciaFisica, Alergia alergia, UsaMedicamentos usaMedicamentos,
			String observacao) {
		super(id, nome, mae, pai, dataNascimento, dataCadastro, nacionalidade, email, telefone1, telefone2, rg,
				orgaoEmissor, cpf, religiao, sexo, status, estadoCivil, tipoSanguinio, cidade);

		this.deficienciaFisica = deficienciaFisica.getCod();
		this.alergia = alergia.getCod();
		this.usaMedicamentos = usaMedicamentos.getCod();
		this.observacao = observacao;

	}

	public DeficienciaFisica getDeficienciaFisica() {
		return DeficienciaFisica.toEnum(this.deficienciaFisica);
	}

	public void setDeficienciaFisica(DeficienciaFisica deficienciaFisica) {
		this.deficienciaFisica = deficienciaFisica.getCod();
	}

	public Alergia getAlergia() {
		return Alergia.toEnum(this.alergia);
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia.getCod();
	}

	public UsaMedicamentos getUsaMedicamentos() {
		return UsaMedicamentos.toEnum(this.usaMedicamentos);
	}

	public void setUsaMedicamentos(UsaMedicamentos usaMedicamentos) {
		this.usaMedicamentos = usaMedicamentos.getCod();
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
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

	public List<Mensalidade> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<Mensalidade> mensalidades) {
		this.mensalidades = mensalidades;
	}

}
