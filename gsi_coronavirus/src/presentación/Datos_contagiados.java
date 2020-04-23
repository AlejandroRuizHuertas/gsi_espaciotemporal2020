package presentación;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dominio.Contagiado;

import javax.swing.JScrollPane;
import java.awt.Cursor;

public class Datos_contagiados extends JFrame {

	private JPanel contentPane;
	private JButton btnEnviarAdvertencia;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { Datos_contagiados frame = new
	 * Datos_contagiados(String localidad, Date fecha); frame.setVisible(true); }
	 * catch (Exception e) { e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 * 
	 * @param fecha
	 * @param localidad
	 */
	public Datos_contagiados(String localidad, String fecha) {
		setResizable(false);
		setTitle("Datos de los contagiados");
		setBounds(100, 100, 757, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 19, 0, 19, 0 };
		gbl_contentPane.rowHeights = new int[] { 14, 0, 20, 0, 22, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);

		JTable table = new JTable(new DefaultTableModel(0, 6));
		table.setAutoCreateRowSorter(true);
		table.setEnabled(false);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);

		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Lugar de contagio", "Fecha de contagio", "Localidad", "Est\u00E1 curado"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(91);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.getColumnModel().getColumn(3).setPreferredWidth(117);
		table.getColumnModel().getColumn(4).setPreferredWidth(113);
		table.getColumnModel().getColumn(5).setPreferredWidth(58);
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();

		modelo = rellenarDatos(localidad, fecha, modelo);
		scrollPane.setViewportView(table);

		btnEnviarAdvertencia = new JButton("Enviar advertencia");
		btnEnviarAdvertencia.addActionListener(new ButtonEnviarActionListener());
		GridBagConstraints gbc_btnEnviarAdvertencia = new GridBagConstraints();
		gbc_btnEnviarAdvertencia.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnviarAdvertencia.gridx = 1;
		gbc_btnEnviarAdvertencia.gridy = 3;
		contentPane.add(btnEnviarAdvertencia, gbc_btnEnviarAdvertencia);
	}

	private DefaultTableModel rellenarDatos(String localidad, String fecha, DefaultTableModel modelo) {

		Vector<Contagiado> contagiados = Contagiado.readAllByDate(localidad, fecha);

		Object[] fila = new Object[6];

		for (int i = 0; i < contagiados.size(); i++) {
			Contagiado c = contagiados.elementAt(i);
			fila[0] = c.getDNI();
			fila[1] = c.getNombre();
			fila[2] = c.getLugar_contagio();
			fila[3] = c.getFecha_contagio().toString();
			fila[4] = c.getLocalidad_contagio();
			fila[5] = c.isCurado();

			// Sección 4
			modelo.addRow(fila);
		}

		return modelo;

	}

	private class ButtonEnviarActionListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int eleccion = JOptionPane.showConfirmDialog(null,
					"Se va a enviar un correo a las pesonas que han estado en contacto"
							+ " con los contagiados. \nEsta operación es irreversible. ¿Está seguro?",
					"Confirmación de envío", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (eleccion == 0)
				btnEnviarAdvertencia.setEnabled(false);

		}

	}
}
