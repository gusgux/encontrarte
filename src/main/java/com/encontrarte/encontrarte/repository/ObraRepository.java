package com.encontrarte.encontrarte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encontrarte.encontrarte.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Long>{
	@Query("SELECT u FROM Obra u WHERE u.id=?1")//estas son basadas en el nombre de tus variablesy no de la base de datos 
	Obra getById(Long id);
	@Query("SELECT u FROM Obra u WHERE u.certificado=?1")
	Obra getByCertificado(String certificado); 
	
}
