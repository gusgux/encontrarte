package com.encontrarte.encontrarte.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encontrarte.encontrarte.model.Formulario;

public interface FormularioRepository  extends JpaRepository<Formulario,Long>{
	
	@Query("SELECT u FROM Formulario u Where u.id=?1")
	 Formulario getById(Long id);
	//metodo sin Optional para consultar por Email
	@Query("SELECT u FROM Formulario u Where u.correo=?1")
	 Formulario getByCorreo(String correo);
	 Optional<Formulario> findByCorreo(String correo);
	
	/* Optional<Formulario> findByEmail(String email); //paola
	 Optional<Formulario> findByName(String name);//alicia
	 Optional<Formulario> findByCertificado(String certificado);//pepe*/
}
