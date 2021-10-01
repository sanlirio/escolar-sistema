package com.escolar.system.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.escolar.system.domain.ValorDespesa;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ValorDespesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	//@NotEmpty(message = "O campo DATA é requerido")
	private LocalDate dataPagamento;
	private BigDecimal valorPagamento;
	private String colaboradorResp;
	private String observacao;
	private Long despesa;

	public ValorDespesaDTO() {
		super();

	}

	public ValorDespesaDTO(ValorDespesa objVDesp) {
		super();
		this.id = objVDesp.getId();
		this.dataPagamento = objVDesp.getDataPagamento();
		this.valorPagamento = objVDesp.getValorPagamento();
		this.colaboradorResp = objVDesp.getColaboradorResp();
		this.observacao = objVDesp.getObservacao();
		this.despesa = objVDesp.getDespesa().getId();
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

	public BigDecimal getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(BigDecimal valorPagamento) {
		this.valorPagamento = valorPagamento;
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

	public Long getDespesa() {
		return despesa;
	}

	public void setDespesa(Long despesa) {
		this.despesa = despesa;
	}

}
