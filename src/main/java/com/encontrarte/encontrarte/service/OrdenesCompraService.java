package com.encontrarte.encontrarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encontrarte.encontrarte.model.OrdenesCompra;
import com.encontrarte.encontrarte.repository.OrdenesCompraRepository;

@Service
public class OrdenesCompraService {
	private final OrdenesCompraRepository ordenDeCompraService;
	@Autowired
	public OrdenesCompraService(OrdenesCompraRepository ordenDeCompraService) {
		this.ordenDeCompraService = ordenDeCompraService;
	}
	//GET ALL
	public List<OrdenesCompra> getordenDeCompra(){
		return ordenDeCompraService.findAll();
	}
	
	
	//GET byID
	
	//POST
	public void addOrdenDeCompra(OrdenesCompra ordenDeCompra) {
		/*
		Optional<OrdenDeCompra>clientByEmail=clientRepository.findByEmail=ordenDeCompraService.findByEmail(ordenDeCompra.);
		if(clientByEmail.isPresent()) {		
		throw new IllegalStateException("El cliente ya se encuentra registrado");}
		*/
		ordenDeCompraService.save(ordenDeCompra);	
		}
	
	

}
