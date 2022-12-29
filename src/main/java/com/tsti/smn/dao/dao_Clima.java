package com.tsti.smn.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.entidades.Clima;

@Repository
public interface dao_Clima extends JpaRepository<Clima,Integer>{
		
		
}
