package com.escolar.system.domain.enums;

public enum FormaPagamento {

	ESPECIE(0,"ESPECIE"),
	CREDITO(1,"CREDITO"),
	DEBITO(2,"DEBITO");
	
	private Integer cod;
	private String descricao;
	
	
	private FormaPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}


	public Integer getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}
	
	public static FormaPagamento toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(FormaPagamento x : FormaPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Forma de Pagamento invalido" + cod);
	}
	
}
