package dominio;

import java.util.Vector;

public class Localidad {
	private String nombre;
	private double[] coordenadas = new double[2];
	private int poblacion;
	private Vector<Contagiado> contagiados;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double[] getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(double[] coordenadas) {
		this.coordenadas = coordenadas;
	}
	public int getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(int poblacion) {
		this.poblacion = poblacion;
	}
	public Vector<Contagiado> getContagiados() {
		return contagiados;
	}
	public void setContagiados(Vector<Contagiado> contagiados) {
		this.contagiados = contagiados;
	}

	
}
