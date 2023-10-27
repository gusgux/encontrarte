package com.encontrarte.encontrarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "artista")
public class Artista {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_artista", unique=true, nullable=false)
	//Atributos
	private Long id;
	private String tecnicas;
	private String categorias;
	private String certificado;
	private Long usuario_id_usuario;
	
	
	//Constructor vacio
	public Artista() {
	}
	
	//Constructor
	public Artista(Long id, String tecnicas, String categorias, String certificado, Long usuario_id_usuario) {
		super();
		this.id = id;
		this.tecnicas = tecnicas;
		this.categorias = categorias;
		this.certificado = certificado;
		this.usuario_id_usuario = usuario_id_usuario;
	}
	
	//Getters Setter
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTecnicas() {
		return tecnicas;
	}
	public void setTecnicas(String tecnicas) {
		this.tecnicas = tecnicas;
	}
	public String getCategorias() {
		return categorias;
	}
	public void setCategorias(String categorias) {
		this.categorias = categorias;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public Long getUsuario_id_usuario() {
		return usuario_id_usuario;
	}
	public void setUsuario_id_usuario(Long usuario_id_usuario) {
		this.usuario_id_usuario = usuario_id_usuario;
	}
	
	//toString
	@Override
	public String toString() {
		return "Artista [id=" + id + ", tecnicas=" + tecnicas + ", categorias=" + categorias + ", certificado="
				+ certificado + ", usuario_id_usuario=" + usuario_id_usuario + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//Final
