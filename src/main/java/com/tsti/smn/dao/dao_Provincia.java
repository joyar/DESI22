package com.tsti.smn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.entidades.Provincia;

@Repository
public interface dao_Provincia extends JpaRepository<Provincia , Integer>{

}
