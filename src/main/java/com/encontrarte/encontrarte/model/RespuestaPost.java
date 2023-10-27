package com.encontrarte.encontrarte.model;

public class RespuestaPost {
	
	private String mensaje;
    private Object datos;
	public RespuestaPost(String mensaje, Object datos) {
	
		this.mensaje = mensaje;
		this.datos = datos;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Object getDatos() {
		return datos;
	}
	public void setDatos(Object datos) {
		this.datos = datos;
	}
	@Override
	public String toString() {
		return "RespuestaPost [mensaje=" + mensaje + ", datos=" + datos + "]";
	}


}
