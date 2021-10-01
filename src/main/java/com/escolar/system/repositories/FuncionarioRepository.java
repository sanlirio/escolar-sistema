package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	@Query("SELECT objFun FROM Funcionario objFun WHERE objFun.cpf =:cpf") // EXCESSAO PARA CPF JA CADASTRADO
	Funcionario findByCPF(@Param("cpf") String cpf);

}
