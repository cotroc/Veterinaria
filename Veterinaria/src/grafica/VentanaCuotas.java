package grafica;
import logica.Socios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaCuotas extends JFrame {

	private JPanel contentPane;
	private JLabel lblTotalCuotas;
	private JTextField txtTotalCuotas;
	private JButton btnAceptar;
	private Socios coleccion;

	public VentanaCuotas(Socios cole) {
		this.coleccion = cole;
		setTitle("Cuotas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 285, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTotalCuotas = new JLabel("Total a cobrar:");
		lblTotalCuotas.setBounds(21, 11, 130, 20);
		contentPane.add(lblTotalCuotas);
		
		txtTotalCuotas = new JTextField();
		txtTotalCuotas.setBounds(161, 11, 86, 20);
		contentPane.add(txtTotalCuotas);
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtTotalCuotas.setText(Double.toString(coleccion.totalCuota()));
				
			}
		});
		btnAceptar.setBounds(91, 55, 89, 23);
		contentPane.add(btnAceptar);
	}
	
	public void setTxtTotalCuotas(String datos) {
		txtTotalCuotas.setText(datos);
	}

}
