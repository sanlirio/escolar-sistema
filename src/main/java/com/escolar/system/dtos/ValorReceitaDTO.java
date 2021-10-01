package com.escolar.system.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.ValorReceita;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ValorReceitaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotEmpty(message = "O campo DATA é requerido")
	private LocalDate dataRecebimento;
	private BigDecimal valorRecebido;
	private BigDecimal valorDesconto;
	private Integer formaPagamento;
	private String colaboradorResp;
	private String observacao;
	private Long receita;

	public ValorReceitaDTO() {
		super();

	}

	public ValorReceitaDTO(ValorReceita objVRec) {
		super();
		this.id = objVRec.getId();
		this.dataRecebimento = objVRec.getDataRecebimento();
		this.valorRecebido = objVRec.getValorRecebido();
		this.valorDesconto = objVRec.getValorDesconto();
		this.formaPagamento = objVRec.getFormaPagamento().getCod();
		this.colaboradorResp = objVRec.getColaboradorResp();
		this.observacao = objVRec.getObservacao();
		this.receita = objVRec.getReceita().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDate dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
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

	public Long getReceita() {
		return receita;
	}

	public void setReceita(Long receita) {
		this.receita = receita;
	}

}
