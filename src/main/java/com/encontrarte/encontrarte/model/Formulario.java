package com.encontrarte.encontrarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="formulario") 
public class Formulario {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="id_formulario",unique=true,nullable=false)
	private Long id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String telefono;
	private String mensaje;
	private String motivo;


	public Formulario() {
	}


	public Formulario(Long id, String nombre, String apellidos, String correo, String telefono, String mensaje,
			String motivo) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.telefono = telefono;
		this.mensaje = mensaje;
		this.motivo = motivo;
	}


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


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public String getMotivo() {
		return motivo;
	}


	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}


	@Override
	public String toString() {
		return "Formulario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", telefono=" + telefono + ", mensaje=" + mensaje + ", motivo=" + motivo + "]";
	}

	
	
}
