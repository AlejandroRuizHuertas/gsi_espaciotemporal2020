package presentación;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Frame;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;

import dominio.Contagiado;
import dominio.Localidad;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;

public class Ventana_principal extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JPanel panelLogo;
	private Vector<Localidad> localidades;
	private Vector<Contagiado> contagiados;
	private JLabel lblPoblacin;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private GridBagConstraints gbc_btnEntrar;
	private JCalendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_principal frame = new Ventana_principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana_principal() {
		setResizable(false);
		System.setProperty("jxbrowser.license.key",
				"1BNDHFSC1FV65BLSXDRI6447N116NYY0FFYHL7W3TZEMO2ATOZ1LBHU704PE3IPEBL5R40");

		Engine engine = Engine.newInstance(EngineOptions.newBuilder(HARDWARE_ACCELERATED).build());
		Browser browser = engine.newBrowser();
		browser.navigation()
				.loadUrl("https://www.openstreetmap.org/?mlat=38.98626&mlon=-3.92907#map=16/38.9857/-3.9301");
		// BrowserView view = new BrowserView(browser);

		frame = new JFrame();
		// frame.getContentPane().setLayout(new MigLayout("", "[1897.00px]",
		// "[1026.00px,fill][grow][]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_principal.class.getResource("/img/covid.png")));
		frame.setResizable(false);
		// frame.setBounds(100, 100, 322, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setVisible(true);
		JPanel panelMapa = new JPanel();

		panelMapa.setBounds(22, 11, 1500, 1000);
		GridBagConstraints gbc_panelMapa = new GridBagConstraints();
		gbc_panelMapa.fill = GridBagConstraints.BOTH;
		gbc_panelMapa.gridheight = 9;
		gbc_panelMapa.insets = new Insets(0, 0, 5, 5);
		gbc_panelMapa.gridx = 3;
		gbc_panelMapa.gridy = 1;

		setTitle("COVID-19 - Seleccion BBDD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, screenSize.width, screenSize.height);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 33, 154, 0, 0, 60, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 19, 72, 31, 22, 0, 0, 0, 0, 0, 0, 19, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };

		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 35, 0, 26, 0 };
		gbl_panel.rowHeights = new int[] { 33, 0, 0, 28, 0, 0, 16, 0, 23, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		lblNewLabel = new JLabel("Localizar ciudad");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		comboBox = new JComboBox();

		localidades = Localidad.readAll();
		String[] nombresLocalidades = getNombresLocalidades(localidades);

		comboBox.setModel(new DefaultComboBoxModel(nombresLocalidades)); // $NON-NLS-1$ //$NON-NLS-2$

		comboBox.addItemListener(new SeleccionarLocalidad());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		panel.add(comboBox, gbc_comboBox);

		JLabel lblDatosPorFechas = new JLabel("Datos por fechas");
		GridBagConstraints gbc_lblDatosPorFechas = new GridBagConstraints();
		gbc_lblDatosPorFechas.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosPorFechas.gridx = 1;
		gbc_lblDatosPorFechas.gridy = 4;
		panel.add(lblDatosPorFechas, gbc_lblDatosPorFechas);

		calendar = new JCalendar();

		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.gridx = 1;
		gbc_calendar.gridy = 5;
		panel.add(calendar, gbc_calendar);

		JButton btnRealizarBusqueda = new JButton("Realizar b\u00FAsqueda");
		btnRealizarBusqueda.addActionListener(new ButtonRealizarBusquedaActionListener());
		GridBagConstraints gbc_btnRealizarBusqueda = new GridBagConstraints();
		gbc_btnRealizarBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_btnRealizarBusqueda.gridx = 1;
		gbc_btnRealizarBusqueda.gridy = 7;
		panel.add(btnRealizarBusqueda, gbc_btnRealizarBusqueda);
		contentPane.add(panelMapa, gbc_panelMapa);

		JPanel panelResultados = new JPanel();
		panelResultados.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagConstraints gbc_panelResultados = new GridBagConstraints();
		gbc_panelResultados.anchor = GridBagConstraints.WEST;
		gbc_panelResultados.gridheight = 7;
		gbc_panelResultados.insets = new Insets(0, 0, 5, 5);
		gbc_panelResultados.fill = GridBagConstraints.VERTICAL;
		gbc_panelResultados.gridx = 1;
		gbc_panelResultados.gridy = 3;
		contentPane.add(panelResultados, gbc_panelResultados);
		GridBagLayout gbl_panelResultados = new GridBagLayout();
		gbl_panelResultados.columnWidths = new int[] { 31, 46, 0, 36, 24, 0 };
		gbl_panelResultados.rowHeights = new int[] { 28, 14, 0, 0, 0, 24, 23, 0 };
		gbl_panelResultados.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelResultados.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panelResultados.setLayout(gbl_panelResultados);

		JLabel lblPoblacin = new JLabel("Poblaci\u00F3n:");
		GridBagConstraints gbc_lblPoblacin = new GridBagConstraints();
		gbc_lblPoblacin.anchor = GridBagConstraints.WEST;
		gbc_lblPoblacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoblacin.gridx = 1;
		gbc_lblPoblacin.gridy = 1;
		panelResultados.add(lblPoblacin, gbc_lblPoblacin);

		JLabel label_2 = new JLabel("0");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 2;
		gbc_label_2.gridy = 1;
		panelResultados.add(label_2, gbc_label_2);

		JLabel label = new JLabel("0");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 2;
		panelResultados.add(label, gbc_label);

		JLabel lblNumContagiados = new JLabel("N\u00FAmero de contagiados:");
		GridBagConstraints gbc_lblNumContagiados = new GridBagConstraints();
		gbc_lblNumContagiados.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumContagiados.anchor = GridBagConstraints.NORTH;
		gbc_lblNumContagiados.gridx = 1;
		gbc_lblNumContagiados.gridy = 2;
		panelResultados.add(lblNumContagiados, gbc_lblNumContagiados);

		JLabel label_1 = new JLabel("0");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 3;
		panelResultados.add(label_1, gbc_label_1);

		JButton btnVerDatosContagiados = new JButton("Ver datos de los contagiados");
		btnVerDatosContagiados.addActionListener(new ButtonVerDatosActionListener());

		JLabel lblNmeroDeCurados = new JLabel("N\u00FAmero de curados:");
		GridBagConstraints gbc_lblNmeroDeCurados = new GridBagConstraints();
		gbc_lblNmeroDeCurados.anchor = GridBagConstraints.WEST;
		gbc_lblNmeroDeCurados.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmeroDeCurados.gridx = 1;
		gbc_lblNmeroDeCurados.gridy = 3;
		panelResultados.add(lblNmeroDeCurados, gbc_lblNmeroDeCurados);
		GridBagConstraints gbc_btnVerDatosContagiados = new GridBagConstraints();
		gbc_btnVerDatosContagiados.gridwidth = 3;
		gbc_btnVerDatosContagiados.insets = new Insets(0, 0, 5, 5);
		gbc_btnVerDatosContagiados.gridx = 1;
		gbc_btnVerDatosContagiados.gridy = 5;
		panelResultados.add(btnVerDatosContagiados, gbc_btnVerDatosContagiados);

		GridBagConstraints gbc_btnAbrirBbdd = new GridBagConstraints();
		gbc_btnAbrirBbdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbrirBbdd.gridx = 2;
		gbc_btnAbrirBbdd.gridy = 3;
		GridBagConstraints gbc_labelBBDDSeleccionada = new GridBagConstraints();
		gbc_labelBBDDSeleccionada.insets = new Insets(0, 0, 5, 5);
		gbc_labelBBDDSeleccionada.gridx = 2;
		gbc_labelBBDDSeleccionada.gridy = 4;

		gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 2;
		gbc_btnEntrar.gridy = 5;

		SwingUtilities.invokeLater(() -> {
			BrowserView view = BrowserView.newInstance(browser);
			// panelMapa.setSize(900, 900);
			// view.setSize(900, 900);

			panelMapa.add(view);
			pack();
		});

	}

	private class SeleccionarLocalidad implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			System.out.println("Bien");
			// Luego ya si eso
		}

	}

	private class ButtonRealizarBusquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}

	}

	private class ButtonVerDatosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String localidad = comboBox.getSelectedItem().toString();

			//Aquí cambiamos el formato de fecha para que MySQL se lo trague
			Date fecha = calendar.getDate();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			String fechaMYSQL = formatter.format(fecha);
			
			Datos_contagiados frameDC = new Datos_contagiados(localidad, fechaMYSQL);

			frameDC.setVisible(true);
		}

	}

	private String[] getNombresLocalidades(Vector<Localidad> localidades) {
		int num_localidades = localidades.size();
		String[] nombres = new String[num_localidades];

		for (int i = 0; i < num_localidades; i++) {
			nombres[i] = localidades.elementAt(i).getNombre();
		}

		return nombres;
	}

}
