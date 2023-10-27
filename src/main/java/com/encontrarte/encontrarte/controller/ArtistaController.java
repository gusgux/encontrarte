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

import com.encontrarte.encontrarte.model.Artista;
import com.encontrarte.encontrarte.service.ArtistaService;

@RestController
@RequestMapping(path ="/api/artista")
@CrossOrigin (origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ArtistaController {
	
	private final ArtistaService artistaController;
	
	@Autowired
	public ArtistaController (ArtistaService artistaController) {
		this.artistaController = artistaController;
	}
	
	//GET ALL Data form tecnicas table
	@GetMapping
	public List<Artista> getArtista(){
		return artistaController.getArtista();
	}
	@GetMapping("byId")
    public ResponseEntity<Artista> getArtistaByID(@RequestParam Long id){
		Artista artista=artistaController.getArtistaById(id);
        return new  ResponseEntity<>(artista,HttpStatus.OK);
    }

    //----------------------------------//


    //----------------------------------//
    //Crear un metodo GET by Email utlizando una querry personalizada que incluye parametros de consulta

    @GetMapping("byCertificado")
    public ResponseEntity<Artista> getArtistaByCertificado(@RequestParam String certificado){
    	Artista artista=artistaController.getArtistaByCertificado(certificado);
        return new  ResponseEntity<>(artista,HttpStatus.OK);
    }
	
	//PUT actualizar
	@PutMapping(path= "{id}")
    public Artista updateClient(@PathVariable("id") Long id,@RequestBody Artista artista) {
         artista.setId(id);
            return artistaController.updateArtista(artista);
    }
	
	//DELETE
	@DeleteMapping(path="{id}")
	public void deleteArtista(@PathVariable("id")Long id) {
		artistaController.deleteArtista(id);
	}
	
	
	
	//POST METHOD
	@PostMapping
	public void postArtista(@RequestBody Artista artista) {
		artistaController.addArtista(artista);
	}
	

	
	
}//final 
