package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escolar.system.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	@Query("SELECT obj FROM Pessoa obj WHERE obj.cpf = :cpf")
	Pessoa findByCPF(@Param("cpf") String cpf);
}
