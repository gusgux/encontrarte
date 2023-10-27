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

import com.encontrarte.encontrarte.model.Tecnicas;
import com.encontrarte.encontrarte.service.TecnicasService;

@RestController  //Decimos que es una API Rest que trabaja con metodos GET PUT POST DELETE
@RequestMapping(path= "/api/tecnicas") //Aqui defino la ruta de nuestra API, es decir,, el endpoint http://localhost:8080/
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })

public class TecnicasController {
	
	private final TecnicasService tecnicasController;

	@Autowired
	public TecnicasController(TecnicasService tecnicasController) {
		this.tecnicasController = tecnicasController;
	}
	
	//GET ALL Data form tecnicas table
	@GetMapping
	public List<Tecnicas> getTecnicas(){
		return tecnicasController.getTecnicas();
	}
	
	//GET byId
	@GetMapping("byId") //http://localhost:8080/api/tecnicas/byId?id=3
    public ResponseEntity<Tecnicas> getTecnicasByID(@RequestParam Long id){
		Tecnicas tecnicas=tecnicasController.getTecnicasById(id);
        return new  ResponseEntity<>(tecnicas,HttpStatus.OK);
    }

	//GET by nombre
    @GetMapping("byNombre") //http://localhost:8080/api/tecnicas/byNombre?nombre=Acrílico
    public ResponseEntity<Tecnicas> getTecnicasByNombre(@RequestParam String nombre){
    	Tecnicas tecnicas=tecnicasController.getTecnicasByNombre(nombre);
        return new  ResponseEntity<>(tecnicas,HttpStatus.OK);
    }
	
	//PUT
	@PutMapping (path = "{id}")
	public Tecnicas updateTecnicas(@PathVariable("id") Long id, @RequestBody Tecnicas tecnicas) {
		tecnicas.setId(id);
		return tecnicasController.updateTecnicas(tecnicas);
	}
	
	//DELETE
	@DeleteMapping(path = "{id}")
	public void deleteTecnicas(@PathVariable("id")Long id) {
		tecnicasController.deleteTecnicas(id);
	}
	
	//POST 
	@PostMapping
	public void postTecnicas(@RequestBody Tecnicas tecnicas) {
		tecnicasController.addTecnicas(tecnicas);
	}
		//fin metodo
	
	
	

}
