package com.encontrarte.encontrarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity// Nos permite establecer la java class como entidad para conectarnos con la DB
	@Table (name= "obras") 
public class Obra {

	
		@Id//me define mi punto de entrada (primary key) para que Spring boot sepa donde inicia la conexión de mi variable con la columna de la tabla 
		@GeneratedValue(strategy=GenerationType.IDENTITY)// es una anotación que se aplia sobre la anotación Id para indicar que va a ser auto incremental 
		@Column(name="id_obra", unique=true, nullable=false)
		private Long id;
		private String titulo;
		private String descripcion;
		private int largo;
		private int ancho;
		private int precio;
		private String certificado; 
		private String tecnica;
		private String categoria;
		private String imagen_obligatoria;
		private String imagen2;
		private String imagen3;
		private String imagen4;
		private String status;
		private Long artista_id_artista; //pareciera que la foreing key debe de llevar el mismo nombre
		
		//constructor vacío
		public Obra() {}
		//constructor

		public Obra(Long id, String titulo, String descripcion, int largo, int ancho, int precio, String certificado,
				String tecnica, String categoria, String imagen_obligatoria, String imagen2, String imagen3,
				String imagen4, String status, Long artista_id_artista) {
			this.id = id;
			this.titulo = titulo;
			this.descripcion = descripcion;
			this.largo = largo;
			this.ancho = ancho;
			this.precio = precio;
			this.certificado = certificado;
			this.tecnica = tecnica;
			this.categoria = categoria;
			this.imagen_obligatoria = imagen_obligatoria;
			this.imagen2 = imagen2;
			this.imagen3 = imagen3;
			this.imagen4 = imagen4;
			this.status = status;
			this.artista_id_artista = artista_id_artista;
		}
		////////////////////////
		//Getters y setters
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public int getLargo() {
			return largo;
		}

		public void setLargo(int largo) {
			this.largo = largo;
		}

		public int getAncho() {
			return ancho;
		}

		public void setAncho(int ancho) {
			this.ancho = ancho;
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}

		public String getCertificado() {
			return certificado;
		}

		public void setCertificado(String certificado) {
			this.certificado = certificado;
		}

		public String getTecnica() {
			return tecnica;
		}

		public void setTecnica(String tecnica) {
			this.tecnica = tecnica;
		}

		public String getCategoria() {
			return categoria;
		}

		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}

		public String getImagen_obligatoria() {
			return imagen_obligatoria;
		}

		public void setImagen_obligatoria(String imagen_obligatoria) {
			this.imagen_obligatoria = imagen_obligatoria;
		}

		public String getImagen2() {
			return imagen2;
		}

		public void setImagen2(String imagen2) {
			this.imagen2 = imagen2;
		}

		public String getImagen3() {
			return imagen3;
		}

		public void setImagen3(String imagen3) {
			this.imagen3 = imagen3;
		}

		public String getImagen4() {
			return imagen4;
		}

		public void setImagen4(String imagen4) {
			this.imagen4 = imagen4;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Long getArtista_id_artista() {
			return artista_id_artista;
		}

		public void setArtista_id_artista(Long artista_id_artista) {
			this.artista_id_artista = artista_id_artista;
		}

		@Override
		public String toString() {
			return "Obra [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", largo=" + largo
					+ ", ancho=" + ancho + ", precio=" + precio + ", certificado=" + certificado + ", tecnica="
					+ tecnica + ", categoria=" + categoria + ", imagen_obligatoria=" + imagen_obligatoria + ", imagen2="
					+ imagen2 + ", imagen3=" + imagen3 + ", imagen4=" + imagen4 + ", status=" + status
					+ ", artista_id_artista=" + artista_id_artista + "]";
		}
		
		
		

	
		
		
		
		
	}

