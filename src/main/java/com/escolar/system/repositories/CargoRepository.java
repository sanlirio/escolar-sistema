package com.escolar.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escolar.system.domain.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
