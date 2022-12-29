package com.tsti.smn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.entidades.AdministradorSMN;

@Repository
public interface dao_AdministradorSMN extends JpaRepository<AdministradorSMN,Long>{

}
