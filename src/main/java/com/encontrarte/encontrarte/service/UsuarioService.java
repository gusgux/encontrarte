package com.encontrarte.encontrarte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encontrarte.encontrarte.model.Usuario;
import com.encontrarte.encontrarte.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioService;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioService) {
		this.usuarioService = usuarioService;
	}
	//GET ALL
	public List<Usuario> getUsuario(){
		return usuarioService.findAll();
	}
	
	//GET byID
	public Usuario getUsuarioById(Long id) {
		return usuarioService.getById(id);
	}
	
	//GET byEmail
	public Usuario getUsuarioByCorreo(String correo) {
		return usuarioService.getByCorreo(correo);
	}
	
	//PUT
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioService.save(usuario);
		
	}
	//DELETE
	public void deleteUsuario(Long id) {
		if(usuarioService.existsById(id)) { 
			usuarioService.deleteById(id); 
		}else { 
			throw new IllegalStateException("The usuario with the request Id doesn't exist");
		}
	}//deleteClient
	
	//POST
	public void addUsuario(Usuario usuario) {
		
		Optional<Usuario> usuarioByEmail = usuarioService.findByCorreo(usuario.getCorreo()); 
		if(usuarioByEmail.isPresent()) {
			throw new IllegalStateException("El usuario ya se encuentra registrado");
		}
		usuarioService.save(usuario);
	}
	
	
	
}
