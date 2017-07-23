package grafica;
import logica.Socios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

public class VentanaListado extends JFrame {

	private JPanel contentPane;
	private static Socios coleccion;
	private JTextArea txtArea;
	private JLabel lblNewLabel;
	

	public VentanaListado(Socios cole) {
		this.coleccion = cole;
		setTitle("Lista de socios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Cedula - Nombre - Mascota - Tipo - Cuota - Mas Informacion");
		lblNewLabel.setBounds(23, 9, 364, 14);
		contentPane.add(lblNewLabel);
		
		txtArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(txtArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(20, 30, 300, 200);
		contentPane.add(scroll);
		contentPane.setVisible(true);
		
		
	}
	
	public void setTxtArea(String text) {
		txtArea.setText(text);
	}
}
