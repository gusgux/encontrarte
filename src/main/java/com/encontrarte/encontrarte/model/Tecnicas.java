package com.encontrarte.encontrarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Nos permite establecer la java class como entidad parra conectarnos con la DBa 
@Table(name= "tecnicas") //Me indica a que tabla de la DB se va a conectar

public class Tecnicas {
	@Id //Me define mi punto de entrasada (primary key) para que spring boot sepa donde inicia la conexion de mi variable con la columna de la tabla 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Permite generar valores de manera automatica
	@Column(name="id_tecnica", unique=true, nullable=false)
	//Atributos
	private Long id;
	private String nombre;
	
	
	//Constructor vacio
	public Tecnicas() {
		
	}

	//Constructor
	public Tecnicas(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}


	//getters Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	//tostring
	@Override
	public String toString() {
		return "TecnicasModel [id=" + id + ", nombre=" + nombre + "]";
	}
	

	

	
	

}
