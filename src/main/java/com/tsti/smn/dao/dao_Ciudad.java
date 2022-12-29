package com.tsti.smn.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsti.smn.entidades.Ciudad;

@Repository
public interface dao_Ciudad extends JpaRepository<Ciudad, Integer>{
	

	@Query("SELECT c FROM Ciudad c WHERE c.codigo_postal=?1")
	Ciudad findById(int codigo_postal);

}
