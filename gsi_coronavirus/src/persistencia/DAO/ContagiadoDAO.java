package persistencia.DAO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import dominio.Contagiado;
import persistencia.Agente;

public class ContagiadoDAO {

	public Contagiado read(Contagiado c) {
		Agente a = Agente.getAgente();

		try {
			Vector<Vector> resultado = a.select("SELECT * FROM contagiados WHERE DNI = '" + c.getDNI() + "';");
			Vector<Object> tmp = null;
			if (resultado.size() == 1) {
				tmp = resultado.elementAt(0);

			}

			c.setNombre((String) tmp.elementAt(1));
			c.setLugar_contagio((String) tmp.elementAt(2));
			c.setFecha_contagio(new Date((String) tmp.elementAt(3)));
			c.setLocalidad_contagio((String) tmp.elementAt(4));
			c.setCurado(Boolean.parseBoolean(tmp.elementAt(5).toString()));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public Vector<Contagiado> readAll() {
		Agente a = Agente.getAgente();
		Vector<Contagiado> c = null;
		try {
			Vector<Vector> resultado = a.select("SELECT * FROM contagiados;");
			Vector<Object> tmp = null;
			tmp = resultado.elementAt(0);
			for (int i = 0; i < resultado.size(); i++) {
				String dni = (String) tmp.elementAt(0);
				String nombre = (String) tmp.elementAt(1);
				String lugar_contagio = (String) tmp.elementAt(2);
				Date fecha_contagio = new Date((String) tmp.elementAt(3));
				String localidad_contagio = (String) tmp.elementAt(4);
				boolean esta_curado = Boolean.parseBoolean(tmp.elementAt(5).toString());
				Contagiado cont_tempor = new Contagiado(dni, nombre, lugar_contagio, fecha_contagio, localidad_contagio, esta_curado);
				c.add(cont_tempor);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return c;
		//hacer un read especial para leer contagiados a partir de fechas
	}

}
