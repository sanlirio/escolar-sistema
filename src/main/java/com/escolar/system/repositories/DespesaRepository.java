package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
