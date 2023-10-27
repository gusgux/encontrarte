package com.encontrarte.encontrarte.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encontrarte.encontrarte.model.Tecnicas;


public interface TecnicasRepository extends JpaRepository<Tecnicas, Long>{
	
	//Metodo sin Optional para consultar por id
	@Query("SELECT u FROM Tecnicas u WHERE u.id=?1")
	Tecnicas getById (Long id);
			
	//Metodo sin Optional para consultar por Nombre
	@Query("SELECT u FROM Tecnicas u WHERE u.nombre=?1")
	Tecnicas getByNombre (String nombre);
	
	Optional<Tecnicas> findByNombre(String nombre);

}
