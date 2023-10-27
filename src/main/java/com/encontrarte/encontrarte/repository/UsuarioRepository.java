package com.encontrarte.encontrarte.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.encontrarte.encontrarte.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query ("SELECT u FROM Usuario u WHERE u.id=?1")
	Usuario getById (Long id);
	
	//Metodo sin Optional para consultar por Email
	@Query ("SELECT u FROM Usuario u WHERE u.correo=?1")
	Usuario getByCorreo (String correo);
	
	Optional<Usuario> findByCorreo(String correo);

}
