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

import com.encontrarte.encontrarte.model.Formulario;
import com.encontrarte.encontrarte.model.RespuestaPost;
import com.encontrarte.encontrarte.service.FormularioService;

@RestController
@RequestMapping(path="/api/formulario") 
@CrossOrigin(origins="*",methods= {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT}) 
public class FormularioController {
	
	private final FormularioService formularioController;
	@Autowired
	public FormularioController(FormularioService formularioController) {
		this.formularioController = formularioController;
	}

	//GET all Data from formulario table
	@GetMapping
	public List<Formulario> getFormulario(){
		return formularioController.getFormulario();
	}

	//GET by ID
	
	@GetMapping("byId")
	public ResponseEntity<Formulario> getFormularioByID(@RequestParam Long id){
		Formulario formulario=formularioController.getFormularioById(id);
		return new  ResponseEntity<>(formulario,HttpStatus.OK);
	}
	
	//GET by Email
	
	@GetMapping("byCorreo")
	public ResponseEntity<Formulario> getFormularioBycorreo(@RequestParam String correo){
		Formulario formulario=formularioController.getFormularioByCorreo(correo);
		return new  ResponseEntity<>(formulario,HttpStatus.OK);
	}
	
	//GET by email
	
	//PUT actualizar
	@PutMapping(path= "{id}")
	public Formulario updateFormulario(@PathVariable("id") Long id,@RequestBody Formulario formulario) {
		 formulario.setId(id);	
			return formularioController.updateFormulario(formulario);
	}
	
	//DELETE
	@DeleteMapping(path="{id}")
	public void deleteFormulario(@PathVariable("id") Long id) {
		formularioController.deleteFormulario(id);
		
	}
		
	
	//POST METHOD Formulario table
	@PostMapping
	public  ResponseEntity<RespuestaPost> postFormulario(@RequestBody Formulario formulario) {
		
		formularioController.addFormulario(formulario);
		RespuestaPost respuesta=new RespuestaPost("existoso",formulario);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
		
	}
}
