package dominio;



import java.util.Date;
import java.util.Vector;

import persistencia.DAO.ContagiadoDAO;

public class Contagiado {
	private String DNI;
	private String nombre;
	private String lugar_contagio;
	private Date fecha_contagio;
	private String localidad_contagio;
	private boolean curado;

	private ContagiadoDAO contagiadoDAO;
	
	public Contagiado() {
		contagiadoDAO = new ContagiadoDAO();
	}
	


	public Contagiado(String dNI, String nombre, String lugar_contagio, Date fecha_contagio, String localidad_contagio,
			boolean curado) {
		super();
		DNI = dNI;
		this.setNombre(nombre);
		this.lugar_contagio = lugar_contagio;
		this.fecha_contagio = fecha_contagio;
		this.setLocalidad_contagio(localidad_contagio);
		this.curado = curado;
		contagiadoDAO = new ContagiadoDAO();
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getLugar_contagio() {
		return lugar_contagio;
	}
	public void setLugar_contagio(String lugar_contagio) {
		this.lugar_contagio = lugar_contagio;
	}
	public boolean isCurado() {
		return curado;
	}
	public void setCurado(boolean curado) {
		this.curado = curado;
	}
	public Date getFecha_contagio() {
		return fecha_contagio;
	}
	public void setFecha_contagio(Date fecha_contagio) {
		this.fecha_contagio = fecha_contagio;
	}
	
	public Vector<Contagiado> readAll(){
		Vector<Contagiado> v = contagiadoDAO.readAll();
		return v;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getLocalidad_contagio() {
		return localidad_contagio;
	}



	public void setLocalidad_contagio(String localidad_contagio) {
		this.localidad_contagio = localidad_contagio;
	}
	
	
}
