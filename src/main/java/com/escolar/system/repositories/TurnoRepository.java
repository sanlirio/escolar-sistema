package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long>{

}
