package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{

}
