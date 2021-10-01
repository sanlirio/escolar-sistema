package com.escolar.system.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.Mensalidade;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MensalidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotEmpty(message = "O campo DATA é requerido")
	private LocalDate dataPagamento;
	private BigDecimal valorPago;
	private BigDecimal valorDesconto;
	private Integer formaPagamento;
	private String colaboradorResp;
	private String observacao;

	private Long aluno;

	public MensalidadeDTO() {
		super();

	}

	public MensalidadeDTO(Mensalidade objMen) {
		super();
		this.id = objMen.getId();
		this.dataPagamento = objMen.getDataPagamento();
		this.valorPago = objMen.getValorPago();
		this.valorDesconto = objMen.getValorDesconto();
		this.formaPagamento = objMen.getFormaPagamento().getCod();
		this.colaboradorResp = objMen.getColaboradorResp();
		this.observacao = objMen.getObservacao();
		this.aluno = objMen.getAluno().getId();

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

	public Integer getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Integer formaPagamento) {
		this.formaPagamento = formaPagamento;
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

	public Long getAluno() {
		return aluno;
	}

	public void setAluno(Long aluno) {
		this.aluno = aluno;
	}

}
