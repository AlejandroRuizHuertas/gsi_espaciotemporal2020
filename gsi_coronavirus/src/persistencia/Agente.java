package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Vector;

public class Agente {

	
	private static Agente mAgente = null;
	Connection mBD = null;
	
	private Agente() {
		
	}
	

	public static Agente getAgente() {
		if (mAgente == null)
			mAgente = new Agente();
		return mAgente;
	}

	private void conectar() throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");
		mBD = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsi_espaciotemporal?user=root&password=root");
	}

	public void desconectar() throws SQLException {
		this.mBD.close();
	}

	public Vector<Vector> select(String SQL) throws Exception {
		conectar();
		Statement stmt = mBD.createStatement();
		ResultSet R = stmt.executeQuery(SQL);
		Vector<Vector> resultado = new Vector<Vector>();

		ResultSetMetaData metaDatos = R.getMetaData();
		Vector registrotemporal = new Vector();

		int numeroDeColumnas = metaDatos.getColumnCount();

		while (R.next()) {
			// procesamos todas las columnas
			for (int i = 1; i <= numeroDeColumnas; i++)
				registrotemporal.add(R.getObject(i));

			resultado.add(registrotemporal);
			registrotemporal = new Vector();
		}
		stmt.close();
		desconectar();
		return resultado;
	}

}