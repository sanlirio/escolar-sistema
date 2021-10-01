package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.TipoAlergia;

@Repository
public interface TipoAlergiaRepository extends JpaRepository<TipoAlergia, Long>{

}
