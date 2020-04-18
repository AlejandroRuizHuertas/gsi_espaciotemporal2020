package dominio;

import java.util.Vector;

import persistencia.DAO.LocalidadDAO;

public class Localidad {
	private String nombre;
	private double[] coordenadas = new double[2];
	private int poblacion;
	static private LocalidadDAO localidadDAO;
	
	public Localidad() {
		localidadDAO = new LocalidadDAO();
	}
	public Localidad(String nombre, double[] coordenadas, int poblacion, Vector<Contagiado> contagiados) {
		super();
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.poblacion = poblacion;
		this.contagiados = contagiados;
		localidadDAO = new LocalidadDAO();
	}
	
	public Localidad(String nombre, double[] coordenadas, int poblacion) {
		super();
		this.nombre = nombre;
		this.coordenadas = coordenadas;
		this.poblacion = poblacion;
		localidadDAO = new LocalidadDAO();
	}
	
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
	
	public static Vector<Localidad> readAll(){
		localidadDAO = new LocalidadDAO();
		
		return localidadDAO.readAll();
	}
	

	
	public String toString() {
		String s = nombre + " " + coordenadas[0] + " " + coordenadas[1]+ " " + poblacion;
		return s;
	}
}
