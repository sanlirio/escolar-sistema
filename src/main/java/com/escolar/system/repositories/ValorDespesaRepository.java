package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.ValorDespesa;

@Repository
public interface ValorDespesaRepository extends JpaRepository<ValorDespesa, Long>{

}
