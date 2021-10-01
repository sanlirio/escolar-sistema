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

import com.escolar.system.domain.enums.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_ValorReceita")
public class ValorReceita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDate dataRecebimento;
	private BigDecimal valorRecebido;
	private BigDecimal valorDesconto;
	private Integer formaPagamento;
	private String colaboradorResp;
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "receita_id")
	private Receita receita;

	public ValorReceita() {

	}

	

	public ValorReceita(Long id, LocalDate dataRecebimento, BigDecimal valorRecebido, BigDecimal valorDesconto,
			FormaPagamento formaPagamento, String colaboradorResp, String observacao, Receita receita) {
		super();
		this.id = id;
		this.dataRecebimento = dataRecebimento;
		this.valorRecebido = valorRecebido;
		this.valorDesconto = valorDesconto;
		this.formaPagamento = formaPagamento.getCod();
		this.colaboradorResp = colaboradorResp;
		this.observacao = observacao;
		this.receita = receita;
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

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
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
		ValorReceita other = (ValorReceita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
