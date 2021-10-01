package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.escolar.system.domain.Responsavel;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
	
	@Query("SELECT objRes FROM Responsavel objRes WHERE objRes.cpf =:cpf") // EXCESSAO PARA CPF JA CADASTRADO
	Responsavel findByCPF(@Param("cpf") String cpf);

}
