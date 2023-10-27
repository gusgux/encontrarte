package com.encontrarte.encontrarte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encontrarte.encontrarte.model.Tecnicas;
import com.encontrarte.encontrarte.repository.TecnicasRepository;

@Service
public class TecnicasService {
	
	private final TecnicasRepository tecnicasService;
	
	@Autowired
	public TecnicasService(TecnicasRepository tecnicasService) {
		this.tecnicasService = tecnicasService;
	}
	
	//GET ALL
	public List<Tecnicas> getTecnicas(){
		return tecnicasService.findAll();
	}
		
	//GET byId	
	public Tecnicas getTecnicasById(Long id) {
		return tecnicasService.getById(id);
	}
	
	//GET by nombre 
	public Tecnicas getTecnicasByNombre(String nombre) {
		return tecnicasService.getByNombre(nombre);
	}
	
	
	//Método PUT. Permite actuaizar la informacion 
	public Tecnicas updateTecnicas(Tecnicas tecnicas) {
		return tecnicasService.save(tecnicas);
	}
	
	//Delete
	public void deleteTecnicas(Long id) {
		if(tecnicasService.existsById(id)) { 
			tecnicasService.deleteById(id); 
			throw new IllegalStateException("El nombre con ese id no existe ");
		}//cierre if else
	}
	
	//POST
	public void addTecnicas(Tecnicas tecnicas) {
			
		Optional <Tecnicas> tecnicasByNombre = tecnicasService.findByNombre(tecnicas.getNombre()); 
		if(tecnicasByNombre.isPresent()) {
			throw new IllegalStateException("La tecnica ya esta registrada");
		}
		tecnicasService.save(tecnicas);
	}
	
	
	
	
	

}
