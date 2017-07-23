package grafica;

import logica.Socios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnInicio;
	private JMenuItem mnItemConfigValores;
	private JMenu mnSocios;
	private JMenuItem mnItemIngresarSocios;
	private JMenuItem mnItemListarSocios;
	private JMenuItem mnItemTotalCuotas;
	private JCheckBox chckbxNewCheckBox;
	private  Socios coleccion;
	

	public VentanaPrincipal(Socios cole) {
		this.coleccion = cole;
		setTitle("Ventana Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnInicio = new JMenu("Inicio");
		menuBar.add(mnInicio);
		
		mnItemConfigValores = new JMenuItem("Configurar Valores");
		mnItemConfigValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfigurarValores configVal = new ConfigurarValores(coleccion);
				configVal.setVisible(true);
			}
		});
		mnInicio.add(mnItemConfigValores);
		
		mnSocios = new JMenu("Socios");
		menuBar.add(mnSocios);
		
		mnItemIngresarSocios = new JMenuItem("Ingresar");
		mnItemIngresarSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				VentanaSocio ventSoc = new VentanaSocio(coleccion);
				ventSoc.setCantidad(coleccion.cantidad());
				ventSoc.setVisible(true);
			}
		});
		mnSocios.add(mnItemIngresarSocios);
		
		mnItemListarSocios = new JMenuItem("Listar");
		mnItemListarSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaListado ventList = new VentanaListado(coleccion);
				ventList.setVisible(true);
				
					ventList.setTxtArea(coleccion.listarSocios());
			}
		});
		mnSocios.add(mnItemListarSocios);
		
		mnItemTotalCuotas = new JMenuItem("Total Cuotas");
		mnItemTotalCuotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(coleccion.getPorcentaje() == 0) {
					JOptionPane.showMessageDialog(null, "Configurar valores primero");
				}
				else {
					VentanaCuotas ventCuo = new VentanaCuotas(coleccion);
					ventCuo.setVisible(true);
				}
				
			}
		});
		mnSocios.add(mnItemTotalCuotas);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
	}

}
