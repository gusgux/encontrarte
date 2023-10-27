package com.encontrarte.encontrarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encontrarte.encontrarte.model.Formulario;
import com.encontrarte.encontrarte.repository.FormularioRepository;

@Service
public class FormularioService {
	
	private final FormularioRepository formularioService;

	@Autowired
	public FormularioService(FormularioRepository formularioService) {
		this.formularioService = formularioService;
	}
	//GET ALL
	
	public List<Formulario> getFormulario(){
		return formularioService.findAll();
	}
	
	//GET byID
	public Formulario getFormularioById(Long id) {
		return formularioService.getById(id);
		}
	
	//GET by Email 
	public Formulario getFormularioByCorreo(String email) {
		return formularioService.getByCorreo(email);
		}
	
	//PUT
	public Formulario updateFormulario (Formulario formulario) {
		return formularioService.save(formulario);
	}
	
	//DELETE
	public void deleteFormulario(Long id) {
	if(formularioService.existsById(id)) {
		formularioService.deleteById(id);
	}else {
		throw new IllegalStateException("The fomulario with the request ID doesn't exist");
	}
	
	
}
	
	
	//POST
	public void addFormulario(Formulario formulario) {
		/*Optional<Formulario> clientByEmail=formularioService.findByEmail(formulario.getCorreo());
		if(clientByEmail.isPresent()) {
			throw new IllegalStateException("El  ya se encuentra registrado");
		}*/
		formularioService.save(formulario);	
	}
}
