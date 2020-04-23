package persistencia.DAO;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Vector;

import dominio.Contagiado;
import persistencia.Agente;

public class ContagiadoDAO {

	public Contagiado read(String nombre) {
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

	static public Vector<Contagiado> readAllByCity(String ciudad) {
		Agente a = Agente.getAgente();
		Vector<Contagiado> c = new Vector<Contagiado>();
		try {
			Vector<Vector> resultado = a.select("SELECT * FROM contagiados WHERE lugar_contagio = '" + ciudad + "';");
			Vector<Object> tmp = null;

			for (int i = 0; i < resultado.size(); i++) {
				tmp = resultado.elementAt(i);
				String dni = (String) tmp.elementAt(0);
				String nombre = (String) tmp.elementAt(1);
				String lugar_contagio = (String) tmp.elementAt(2);
				Date fecha_contagio = (Date)tmp.elementAt(3);
				String localidad_contagio = (String) tmp.elementAt(4);
				boolean esta_curado = Boolean.parseBoolean(tmp.elementAt(5).toString());
				Contagiado cont_tempor = new Contagiado(dni, nombre, lugar_contagio, fecha_contagio, localidad_contagio,
						esta_curado);
				c.add(cont_tempor);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return c;
	}

	static public Vector<Contagiado> readAllByDate(String ciudad, String d) {
		Agente a = Agente.getAgente();
		Vector<Contagiado> c = new Vector<Contagiado>();
		try {
			Vector<Vector> resultado = a
					.select("SELECT * FROM contagiados WHERE fecha_contagio <= '"+d+"' AND localidad_contagio = '"+ciudad+"' ORDER BY fecha_contagio;");
			Vector<Object> tmp = null;
			for (int i = 0; i < resultado.size(); i++) {
				tmp = resultado.elementAt(i);
				String dni = (String) tmp.elementAt(0);
				String nombre = (String) tmp.elementAt(1);
				String lugar_contagio = (String) tmp.elementAt(2);
				Date fecha_contagio = (Date)tmp.elementAt(3);
				String localidad_contagio = (String) tmp.elementAt(4);
				boolean esta_curado = convertir_booleano(tmp.elementAt(5));
				Contagiado cont_tempor = new Contagiado(dni, nombre, lugar_contagio, fecha_contagio, localidad_contagio,
						esta_curado);
				c.add(cont_tempor);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return c;
	}

	private static boolean convertir_booleano(Object elementAt) {
		int valor = Integer.parseInt(elementAt.toString());
		if (valor == 1) {
			return true;
		}
		else {
		return false;
		}
	}

}
