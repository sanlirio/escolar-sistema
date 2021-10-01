package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Aluno;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	@Query("SELECT objAlu FROM Aluno objAlu WHERE objAlu.cpf =:cpf") // EXCESSAO PARA CPF JA CADASTRADO
	Aluno findByCPF(@Param("cpf") String cpf);


}
