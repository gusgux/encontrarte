package com.encontrarte.encontrarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encontrarte.encontrarte.model.Obra;
import com.encontrarte.encontrarte.repository.ObraRepository;

@Service
public class ObraService {
	// instanciamos una clase repository
	
		private final ObraRepository obraRepository;
		
		// generamos el constructor que será la entrada a nuestra inyeción de dependencias usando @Autowired
		@Autowired
		public ObraService(ObraRepository obraRepository){
			this.obraRepository=obraRepository;
		}
		//Crear método que permita ller a todos los clientes de mi DB
		
		
		// método GET para traer todas las obras registradas
		public List<Obra> getObras(){
			return obraRepository.findAll();
		}
		
		//método put para subir una obra
		public Obra getObraById(Long id) {
			return obraRepository.getById(id);
		}
		
		
}
