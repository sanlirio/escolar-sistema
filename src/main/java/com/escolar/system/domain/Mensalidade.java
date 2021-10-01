package com.escolar.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.escolar.system.domain.enums.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_Mensalidade")
public class Mensalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento;
	private BigDecimal valorPago;
	private BigDecimal valorDesconto;
	private Integer formaPagamento;
	private String colaboradorResp;
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	public Mensalidade() {

	}

	public Mensalidade(Long id, LocalDate dataPagamento, BigDecimal valorPago, BigDecimal valorDesconto,
			FormaPagamento formaPagamento, String colaboradorResp, String observacao) {
		super();
		this.id = id;
		this.dataPagamento = dataPagamento;
		this.valorPago = valorPago;
		this.valorDesconto = valorDesconto;
		this.formaPagamento = formaPagamento.getCod();
		this.colaboradorResp = colaboradorResp;
		this.observacao = observacao;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public FormaPagamento getFormaPagamento() {
		return FormaPagamento.toEnum(this.formaPagamento);
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento.getCod();
	}

	public String getColaboradorResp() {
		return colaboradorResp;
	}

	public void setColaboradorResp(String colaboradorResp) {
		this.colaboradorResp = colaboradorResp;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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
		Mensalidade other = (Mensalidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
