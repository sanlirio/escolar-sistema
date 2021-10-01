package com.escolar.system.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.escolar.system.domain.Salario;
import com.fasterxml.jackson.annotation.JsonFormat;

public class SalarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotEmpty(message = "O campo DATA é requerido")
	private LocalDate dataPagamento;
	private BigDecimal valorPago;
	private String funcionarioResp;
	private String observacao;

	private Long funcionario;

	public SalarioDTO() {
		super();

	}

	public SalarioDTO(Salario objSal) {
		super();
		this.id = objSal.getId();
		this.dataPagamento = objSal.getDataPagamento();
		this.valorPago = objSal.getValorPago();
		this.funcionarioResp = objSal.getFuncionarioResp();
		this.observacao = objSal.getObservacao();
		this.funcionario = objSal.getFuncionario().getId();
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

	public String getFuncionarioResp() {
		return funcionarioResp;
	}

	public void setFuncionarioResp(String funcionarioResp) {
		this.funcionarioResp = funcionarioResp;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Long funcionario) {
		this.funcionario = funcionario;
	}

}
