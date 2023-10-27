package com.encontrarte.encontrarte.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.encontrarte.encontrarte.model.OrdenesCompra;
import com.encontrarte.encontrarte.service.OrdenesCompraService;

@RestController  
@RequestMapping(path= "/api/ordenes_compra") 
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST , RequestMethod.PUT , RequestMethod.DELETE})
public class OrdenesCompraController {
	
	private final OrdenesCompraService OrdenesCompraController;
	@Autowired
	public OrdenesCompraController(OrdenesCompraService ordenesCompraController) {
		this.OrdenesCompraController = ordenesCompraController;
	}
	//GET all Data from formulario table
	@GetMapping
	public List<OrdenesCompra> getOrdenDeCompra(){
		return OrdenesCompraController.getordenDeCompra();
	}
	//POST METHOD Formulario table
	//metodo para crear nuevos usuarios esde el service.
	@PostMapping
	public void postOrdenDeCompra(@RequestBody OrdenesCompra ordenesCompra) {
		OrdenesCompraController.addOrdenDeCompra(ordenesCompra);
	}

	
	
	
	
	
	
	
	
	
	

}
