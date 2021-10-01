package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long>{

}
