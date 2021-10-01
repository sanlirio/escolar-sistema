package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.ValorReceita;

@Repository
public interface ValorReceitaRepository extends JpaRepository<ValorReceita, Long>{

}
