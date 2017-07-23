package grafica;
import logica.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaBuscar extends JFrame {

	private JPanel contentPane;
	private Socios coleccion;
	private JTextField txtBusqueda;
	private JLabel lblsocio;
	private JLabel label;
	
	public VentanaBuscar(Socios cole) {
		this.coleccion = cole;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtBusqueda = new JTextField();
		txtBusqueda.setBounds(105, 90, 164, 20);
		contentPane.add(txtBusqueda);
		txtBusqueda.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(coleccion.pertenece(Integer.parseInt(txtBusqueda.getText()))) {
					Socio soc;
					soc = coleccion.buscarSocio(Integer.parseInt(txtBusqueda.getText()));
					VentanaSocio vent = new VentanaSocio(coleccion);
					vent.cargarSocio(soc);
					vent.setVisible(true);
					vent.setStatus("Modificar");
					
					dispose();
					
				}
				label.setText("No existe esa cedula");
				
				
				
			}
		});
		btnBuscar.setBounds(95, 132, 89, 23);
		contentPane.add(btnBuscar);
		
		lblsocio = new JLabel("Ingresar Cedula");
		lblsocio.setBounds(10, 93, 121, 14);
		contentPane.add(lblsocio);
		
		label = new JLabel("");
		label.setBounds(28, 24, 174, 20);
		contentPane.add(label);
	}
}
