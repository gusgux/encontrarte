package com.encontrarte.encontrarte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encontrarte.encontrarte.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{
	//Metodo sin Optional para consultar por id
    @Query("SELECT u FROM Artista u WHERE u.id=?1")
    Artista getById (Long id);

    //Metodo sin Optional para consultar por Email
    @Query("SELECT u FROM Artista u WHERE u.certificado=?1")
    Artista getByCertificado (String certificado);
	
	Optional<Artista> findByCertificado (String certificado);
	
}
