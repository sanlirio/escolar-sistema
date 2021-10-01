package com.escolar.system.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escolar.system.domain.Receita;
import com.escolar.system.domain.ValorReceita;
import com.escolar.system.domain.enums.FormaPagamento;
import com.escolar.system.repositories.ReceitaRepository;
import com.escolar.system.repositories.ValorReceitaRepository;

@Service
public class DBService {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private ValorReceitaRepository valorReceitaRepository;

	
	public void instanciaDB() {

		Receita r1 = new Receita(null, "MENSALIDADE");
		Receita r2 = new Receita(null, "FARDAMENTO");
		ValorReceita VR1 = new ValorReceita(null, null, null, null, FormaPagamento.CREDITO, null, null, r1);
		ValorReceita VR2 = new ValorReceita(null, null, null, null, FormaPagamento.CREDITO, null, null, r2);

		r1.getValorReceitas().add(VR2);
		r2.getValorReceitas().add(VR1);

		receitaRepository.saveAll(Arrays.asList(r1, r2));
		valorReceitaRepository.saveAll(Arrays.asList(VR1, VR2));
	}

}
