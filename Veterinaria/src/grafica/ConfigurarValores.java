package grafica;
import logica.Socios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ConfigurarValores extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescuento;
	private static Socios coleccion;

	public ConfigurarValores(Socios cole) {
		this.coleccion = cole;
		setTitle("Configurar Valores");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 285, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPorcentajeDescuento = new JLabel("Porcentaje Descuento");
		lblPorcentajeDescuento.setBounds(21, 11, 130, 20);
		contentPane.add(lblPorcentajeDescuento);
		
		txtDescuento = new JTextField();
		txtDescuento.setBounds(161, 11, 86, 20);
		contentPane.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int desc;
				desc = Integer.parseInt(txtDescuento.getText());
				coleccion.configurarValores(desc);
				JOptionPane.showMessageDialog(null, "Porcentaje Configurado");
				dispose();
			}
		});
		btnAceptar.setBounds(91, 55, 89, 23);
		contentPane.add(btnAceptar);
	}
}
