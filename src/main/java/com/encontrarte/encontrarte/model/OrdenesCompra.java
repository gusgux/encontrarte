package com.encontrarte.encontrarte.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //Nos permite establecer la java class como entidad parra conectarnos con la DBa 
@Table(name= "ordenes_compra") //Me indica a que tabla de la DB se va a conectar
public class OrdenesCompra {
	@Id //Me define mi punto de entrasada (primary key) para que spring boot sepa donde inicia la conexion de mi variable con la columna de la tabla 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Permite generar valores de manera automatica
	@Column(name="id_orden", unique=true, nullable=false)
	//Atributos
	private Long id_orden;
	private Long id_obras_pedido;
	private String id_orden_pedido;
	private String estado_envio;
	private Long fecha_compra;
	private Long precio;
	private String estado_compra;
	private Long Usuario_id_usuario;
	private String id_transaccion;
	private String metodo;
	private String obras_pedido;
	
	public OrdenesCompra() {
	}
	public OrdenesCompra( String id_orden_pedido, String estado_envio, Long fecha_compra, Long precio,
			String estado_compra, Long usuario_id_usuario, String id_transaccion, String metodo, Long id_orden, Long id_obras_pedido, String obras_pedido) {
	
	;
		this.id_orden = id_orden;
		this.id_obras_pedido = id_obras_pedido;
		this.id_orden_pedido = id_orden_pedido;
		this.estado_envio = estado_envio;
		this.fecha_compra = fecha_compra;
		this.precio = precio;
		this.estado_compra = estado_compra;
		this.Usuario_id_usuario = usuario_id_usuario;
		this.id_transaccion = id_transaccion;
		this.metodo = metodo;
		this.obras_pedido = obras_pedido;


	}
	public String getId_orden_pedido() {
		return id_orden_pedido;
	}
	public void setId_orden_pedido(String id_orden_pedido) {
		this.id_orden_pedido = id_orden_pedido;
	}
	public String getEstado_envio() {
		return estado_envio;
	}
	public void setEstado_envio(String estado_envio) {
		this.estado_envio = estado_envio;
	}
	public Long getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(Long fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public String getEstado_compra() {
		return estado_compra;
	}
	public void setEstado_compra(String estado_compra) {
		this.estado_compra = estado_compra;
	}
	public Long getUsuario_id_usuario() {
		return Usuario_id_usuario;
	}
	public void setUsuario_id_usuario(Long usuario_id_usuario) {
		Usuario_id_usuario = usuario_id_usuario;
	}
	public String getId_transaccion() {
		return id_transaccion;
	}
	public void setId_transaccion(String id_transaccion) {
		this.id_transaccion = id_transaccion;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public Long getId_orden() {
		return id_orden;
	}
	public void setId_orden(Long id_orden) {
		this.id_orden = id_orden;
	}
	public Long getId_obras_pedido() {
		return id_obras_pedido;
	}
	public void setId_obras_pedido(Long id_obras_pedido) {
		this.id_obras_pedido = id_obras_pedido;
	}
	public String getObras_pedido() {
		return obras_pedido;
	}
	public void setObras_pedido(String obras_pedido) {
		this.obras_pedido = obras_pedido;
	}
	@Override
	public String toString() {
		return "OrdenesCompra [id_orden=" + id_orden + ", id_obras_pedido=" + id_obras_pedido
				+ ", id_orden_pedido=" + id_orden_pedido + ", estado_envio=" + estado_envio + ", fecha_compra="
				+ fecha_compra + ", precio=" + precio + ", estado_compra=" + estado_compra + ", Usuario_id_usuario="
				+ Usuario_id_usuario + ", id_transaccion=" + id_transaccion + ", metodo=" + metodo + ", obras_pedido="
				+ obras_pedido + "]";
	}
	
	
	

	
}
	