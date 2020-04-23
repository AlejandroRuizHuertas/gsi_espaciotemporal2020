package persistencia.DAO;

import java.sql.Date;
import java.util.Vector;

import dominio.Contagiado;
import dominio.Localidad;
import persistencia.Agente;

public class LocalidadDAO {

	

	public Vector<Localidad> readAll(){

			Agente a = Agente.getAgente();
			Vector<Localidad> l = new Vector<Localidad>();

				Vector<Vector> resultado;
				try {
					resultado = a.select("SELECT * FROM localidades;");
					Vector<Object> tmp = null;
					
					for (int i = 0; i < resultado.size(); i++) {
						tmp = resultado.elementAt(i);
						String nombre = (String)tmp.elementAt(0);
						double[] coordenadas = new double[2];
						coordenadas[0] = Double.parseDouble(tmp.elementAt(1).toString());
						coordenadas[1] = Double.parseDouble(tmp.elementAt(2).toString());
						int poblacion = Integer.parseInt(tmp.elementAt(3).toString());
						Vector<Contagiado> contagiados = ContagiadoDAO.readAllByCity(nombre);
						Localidad localidad_temporal = new Localidad(nombre, coordenadas, poblacion, contagiados);
						l.addElement(localidad_temporal);

					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		return l;
	}
	public Localidad read(String nombre) {
		Agente a = Agente.getAgente();
		Localidad l = new Localidad();
		try {
			Vector<Vector> resultado = a.select("SELECT * FROM localidades WHERE nombre = '"+nombre+"';");
			Vector<Object> tmp = null;
			if (resultado.size() == 1) {
				tmp = resultado.elementAt(0);
				double[]coordenadas = new double[2];
				coordenadas[0] = Double.parseDouble(tmp.elementAt(1).toString());
				coordenadas[1] = Double.parseDouble(tmp.elementAt(2).toString());
				int poblacion = Integer.parseInt(tmp.elementAt(3).toString());
				Vector<Contagiado> contagiados = ContagiadoDAO.readAllByCity(nombre);
				l.setNombre(nombre);
				l.setCoordenadas(coordenadas);
				l.setContagiados(contagiados);
				l.setPoblacion(poblacion);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	/*
	 * 	public Contagiado read(String nombre) {
		Agente a = Agente.getAgente();
		Contagiado c = new Contagiado();
		try {
			Vector<Vector> resultado = a.select("SELECT * FROM contagiados WHERE DNI = '" + nombre + "';");
			Vector<Object> tmp = null;
			if (resultado.size() == 1) {
				tmp = resultado.elementAt(0);
				c.setNombre((String) tmp.elementAt(1));
				c.setLugar_contagio((String) tmp.elementAt(2));
				c.setFecha_contagio((Date)tmp.elementAt(3));
				c.setLocalidad_contagio((String) tmp.elementAt(4));
				c.setCurado(Boolean.parseBoolean(tmp.elementAt(5).toString()));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	 * */
	
}
