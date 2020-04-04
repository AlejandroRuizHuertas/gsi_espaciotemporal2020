package dominio;

import java.sql.Date;

public class Contagiado {
	private String DNI;
	private String lugar_contagio;
	private boolean curado;
	private Date fecha_contagio;
	
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
	
	
}
