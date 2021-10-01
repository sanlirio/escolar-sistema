package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long>{

}
