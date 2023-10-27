package com.encontrarte.encontrarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id //Me define mi punto de entrada (primary Key) para que Spring boot sepa dónde inicia la conexión de mi variable con la columna de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Permite generar valores de manera automática
	@Column(name = "id_usuario", unique = true, nullable = false)
	//Atributos
	private Long id;
	private String nombres;
	private String apellidos;
	private String correo;
	private String contrasena;
	private String role;
	private String telefono;
	private String id_compras;
	
	public Usuario() {
		
		
	}

	public Usuario(Long id, String nombres, String apellidos, String correo, String contrasena, String role,
			String telefono, String id_compras) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
		this.role = role;
		this.telefono = telefono;
		this.id_compras = id_compras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId_compras() {
		return id_compras;
	}

	public void setId_compras(String id_compras) {
		this.id_compras = id_compras;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", contrasena=" + contrasena + ", role=" + role + ", telefono=" + telefono + ", id_compras="
				+ id_compras + "]";
	}
	
	
	
	
}
