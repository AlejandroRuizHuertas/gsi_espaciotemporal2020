package presentación;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Frame;

public class Seleccion_BBDD extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JPanel panelLogo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Seleccion_BBDD frame = new Seleccion_BBDD();
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
	public Seleccion_BBDD() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Seleccion_BBDD.class.getResource("/img/covid.png")));
		frame.setResizable(false);
		frame.setBounds(100, 100, 322, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel labelLogo = new JLabel("");
		JPanel panelLogo = new JPanel();
		panelLogo.setBounds(22, 11, 266, 174);
		panelLogo.add(labelLogo);
		GridBagConstraints gbc_panelLogo = new GridBagConstraints();
		gbc_panelLogo.insets = new Insets(0, 0, 5, 5);
		gbc_panelLogo.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelLogo.gridx = 2;
		gbc_panelLogo.gridy = 1;
		

		setTitle("COVID-19 - Seleccion BBDD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{19, 0, 19, 0, 0, 25, 18, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		contentPane.add(panelLogo, gbc_panelLogo);
			
		
		JButton btnAbrirBbdd = new JButton("Conectar a la BBDD");
		btnAbrirBbdd.addActionListener(new ButtonActionListener());
		try {
			// imagenOriginal = ImageIO.read(file);
			BufferedImage imagenOriginal = ImageIO.read(Seleccion_BBDD.class.getResource("/img/covid.png"));
			Image imagenEscalada = (imagenOriginal).getScaledInstance(panelLogo.getWidth(), panelLogo.getHeight(),
					java.awt.Image.SCALE_SMOOTH);
			ImageIcon iconoLabel = new ImageIcon(imagenEscalada);
			labelLogo.setIcon(iconoLabel);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
				
	
		GridBagConstraints gbc_btnAbrirBbdd = new GridBagConstraints();
		gbc_btnAbrirBbdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbrirBbdd.gridx = 2;
		gbc_btnAbrirBbdd.gridy = 3;
		contentPane.add(btnAbrirBbdd, gbc_btnAbrirBbdd);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ButtonEntrarActionListener());
		
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 2;
		gbc_btnEntrar.gridy = 5;
		contentPane.add(btnEntrar, gbc_btnEntrar);
	}
	
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			//Llamar a CONECTAR
				
		}
		
	}
	private class ButtonEntrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			 Ventana_principal frameVP = new Ventana_principal();
			 frameVP.setVisible(true);
			 setVisible(false);
		}
	}
	

}
