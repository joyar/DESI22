package com.tsti.smn.dao;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsti.smn.entidades.Ciudad;
import com.tsti.smn.entidades.clima_extendido;

@Repository
public interface dao_clima_extendido extends JpaRepository<clima_extendido , Ciudad>{
	
	@Query("SELECT c FROM clima_extendido c WHERE c.codigo_postal like ?1")
	List<clima_extendido> findById( int id);
	

	@Query("SELECT c FROM clima_extendido c WHERE c.codigo_postal like ?1 AND c.fecha>?2 ORDER BY c.fecha ASC")
	List<clima_extendido> findByIdAndDate( int id, Date a );
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM clima_extendido WHERE id=?1")
	void deleteById(int id);


	@Query("SELECT c_e FROM clima_extendido c_e WHERE c_e.id=?1")
	clima_extendido findByIdClima(int id);

	
}
