package com.escolar.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_ValorDespesa")
public class ValorDespesa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento;
	private BigDecimal valorPagamento;
	private String colaboradorResp;
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "despesa_id")
	private Despesa despesa;

	public ValorDespesa() {

	}

	public ValorDespesa(Long id, LocalDate dataPagamento, BigDecimal valorPagamento, String colaboradorResp,
			String observacao, Despesa despesa) {
		super();
		this.id = id;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.colaboradorResp = colaboradorResp;
		this.observacao = observacao;
		this.despesa = despesa;
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

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
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
		ValorDespesa other = (ValorDespesa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
