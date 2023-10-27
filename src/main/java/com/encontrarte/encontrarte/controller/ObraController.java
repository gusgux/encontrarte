package com.encontrarte.encontrarte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encontrarte.encontrarte.model.Obra;
import com.encontrarte.encontrarte.service.ObraService;

@RestController //Decimos que es una API
@RequestMapping(path = "/obras")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST })

public class ObraController {
	// instanciamos un objeto constante de clase ObraService
		private final ObraService obraService;
		//Constructor que toma el objeto Service y luego indica que aquí se llevará a cabo alguna inyección 
		@Autowired
		public ObraController(ObraService obraService) {
			this.obraService= obraService;
			}
		
		@GetMapping
		public List<Obra> getObras(){
			return obraService.getObras();
		}
		@GetMapping(path="/byId")
		public ResponseEntity<Obra> getObraById(@RequestParam Long id_obra){
			Obra obra=obraService.getObraById(id_obra);
			return new ResponseEntity<>(obra, HttpStatus.OK);
		}
}
