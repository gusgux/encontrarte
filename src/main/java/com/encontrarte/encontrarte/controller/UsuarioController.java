package com.encontrarte.encontrarte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encontrarte.encontrarte.model.Usuario;
import com.encontrarte.encontrarte.service.UsuarioService;

@RestController 
@RequestMapping(path = "/api/usuario") 
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) //Mediante origen cruzado puedo manejar problemas de seguridad. Me permite acceder desde cualquier origina (dominio) a los métodos HTTP
public class UsuarioController {

	private final UsuarioService usuarioController;

	@Autowired
	public UsuarioController(UsuarioService usuarioController) {
		this.usuarioController = usuarioController;
	}
	
	//GET ALL DATA FROM Usuario TABLE
	@GetMapping
	public List<Usuario> getUsuario(){
		return usuarioController.getUsuario();
	}
	
	//GET by ID
	@GetMapping(path = "/byId")
	public ResponseEntity<Usuario> getUsuariotById(@RequestParam Long id){
		Usuario usuario = usuarioController.getUsuarioById(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	//GET by correo
	@GetMapping(path = "byCorreo")
	public ResponseEntity<Usuario> getUsuarioByCorreo(@RequestParam String correo){
		Usuario usuario = usuarioController.getUsuarioByCorreo(correo);
		if (usuario == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	//PUT actualizar
	@PutMapping(path = "{id}")
	public Usuario updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario){
		usuario.setId(id);
		return usuarioController.updateUsuario(usuario);
	}
	
	//DELETE
	@DeleteMapping(path = "{id}")
	public void deleteUsuario(@PathVariable("id") Long id) {
		usuarioController.deleteUsuario(id);
	}
	
	//POST METHOD Usuario Table
	@PostMapping
	public void postUsuario(@RequestBody Usuario usuario) {
		usuarioController.addUsuario(usuario);
	}
	
	
	
	
	

	
	
	
	
	
}
