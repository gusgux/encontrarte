package com.encontrarte.encontrarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encontrarte.encontrarte.model.Artista;
import com.encontrarte.encontrarte.repository.ArtistaRepository;
@Service 
public class ArtistaService {
	
	private final ArtistaRepository artistaService;
	
	@Autowired
	public ArtistaService (ArtistaRepository artistaService) {
		this.artistaService = artistaService;
	}
	
	//GET ALL
	public List<Artista> getArtista(){
		return artistaService.findAll();
	}
	//GET byID
	public Artista getArtistaById(Long id) {
        return artistaService.getById(id);
        }
    //----------------------------------//


    //----------------------------------//
    //Crear un metodo GET by Email utlizando una querry personalizada que incluye parametros de consulta

    public Artista getArtistaByCertificado(String certificado) {
        return artistaService.getByCertificado(certificado);
        }
	
	//PUT
	public Artista updateArtista (Artista artista) {
		return artistaService.save(artista);
	}
	
	//DELETE
	public void deleteArtista(Long id) {
	    if(artistaService.existsById(id)) {// Mediante método JPA evalúo si el cliente existe por ID
	       artistaService.deleteById(id);//si es true, ekecuto un metodo JPA para eliminar el cliente existente por ID
	    }else {//Si es false(no existe ese Id),lanzo una exception
	        throw new IllegalStateException("The artist with the request ID doesn't exist");
	    }


	}
	
	//POST
	public void addArtista(Artista artista) {
			
		/*Optional <Artista> tecnicasByCertificado = artistaService.findByCertificado(artista.getCertificado()); 
		if(tecnicasByCertificado.isPresent()) {
			throw new IllegalStateException("Este certificado ya ha sido declarado");
		}*/
		artistaService.save(artista);
	}
	

}//Final
