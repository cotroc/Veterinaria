package grafica;
import logica.*;

//import logica.Socio;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class VentanaSocio extends JFrame {

	private JPanel contentPane;
	private JLabel lblCedula;
	private JTextField txtCedula;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblNombreMascota;
	private JTextField txtNombreMascota;
	private JLabel lblTipoMascota;
	private JComboBox cmbTipoMascota;
	private JTextField txtCuotaBase;
	private JLabel lblCuotaBase;
	private JCheckBox chbBonificado;
	private JLabel lblAntiguedad;
	private JTextField txtAnios;
	private JButton btnAceptar;
	private Socios coleccion;
	private String campo;
	private JButton btnBuscar;
	private boolean modifica;
	private JTextArea lblStatus;
	private Socio soc;
	private JTextField txtCant;
	private JLabel lblCantidadDeSocios;
	
	
	

	public void setStatus(String stat) {
		lblStatus.setText(stat);
	}
	
	public void setCantidad(int cant) {
		txtCant.setText(Integer.toString(cant));
	}
	public void cargarSocio(Socio soc) {
				
		modifica = true;
		txtCedula.setText(Integer.toString(soc.getCedula()));
		txtCedula.setEditable(false);
		txtNombre.setText(soc.getNombre());
		txtNombreMascota.setText(soc.getNombreMascota());
		cmbTipoMascota.setSelectedItem(soc.getNombreMascota());
		txtCuotaBase.setText(Double.toString(soc.getCuotaBase()));
		if (soc instanceof Bonificado) {
			chbBonificado.setSelected(((Bonificado) soc).getBonificado());
			txtAnios.setText(Integer.toString(((Bonificado) soc).getAntiguedad()));
		}
		
	}
	
public boolean validarDatos() {
		boolean validos = false;
		
		if(chbBonificado.isSelected()) {
			if(validarVacio(txtCedula.getText(), "Cedula")  && validarNumero(txtCedula.getText(),"Cedula") && validarVacio(txtNombre.getText(),"Nombre") && 
					   validarVacio(txtNombreMascota.getText(), "Nombre Mascota") && validarVacio((String) cmbTipoMascota.getSelectedItem(), "Tipo de Mascota") &&
					   validarVacio(txtCuotaBase.getText(), "Cuota Base") && validarNumero(txtCuotaBase.getText(), "Cuota Base") && 
					   validarVacio(txtAnios.getText(), "Antiguedad") && validarNumero(txtAnios.getText(), "Antiguedad")) {
				validos = true;
			}
			else {
				validos = false;
			}
		}
		else {
			if(validarVacio(txtCedula.getText(),"Cedula") && validarNumero(txtCedula.getText(),"Cedula") && validarVacio(txtNombre.getText(), "Nombre") &&
								   validarVacio(txtNombreMascota.getText(), "Nombre Mascota") && validarVacio((String) cmbTipoMascota.getSelectedItem(), "Tipo de Mascota") &&
								   validarVacio(txtCuotaBase.getText(), "Cuota Base") && validarNumero(txtCuotaBase.getText(), "Cuota Base")) {
				validos = true;
				
			}
			else {
				validos = false;
			}
				
		}
		
		return validos;
	}
	
	public boolean validarVacio(String texto, String campo){
		boolean valido = true;
		this.campo = campo;
		if(texto.startsWith(" ") || texto.isEmpty()){
			valido = false;
			
		}
		else{
			valido = true;
		}
		
		return valido;
	
	}
	
	public boolean validarNumero(String numero, String campo) {
		this.campo = campo;
		boolean esNumero = false;
		char[] k = numero.toCharArray();
		
		for(int i=0; i < k.length; i++) {
			if((int)k[i]>= 97 && (int)k[i] <= 122 || (int)k[i] >= 65 && (int)k[i] <= 90) {
				esNumero = false;
				
			}
			else
				esNumero = true;
		}
		
		return esNumero;
	}
	
	public VentanaSocio(Socios cole) {
		this.coleccion = cole;
		setTitle("Ingreso de Socio");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 571, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCedula = new JLabel("# C\u00E9dula*");
		lblCedula.setBounds(18, 75, 100, 20);
		contentPane.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(230, 75, 100, 20);
		contentPane.add(txtCedula);
		
		lblNombre = new JLabel("Nombre*");
		lblNombre.setBounds(18, 105, 100, 20);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(230, 105, 100, 20);
		contentPane.add(txtNombre);
		
		lblNombreMascota = new JLabel("Nombre de Mascota*");
		lblNombreMascota.setBounds(18, 135, 149, 20);
		contentPane.add(lblNombreMascota);
		
		txtNombreMascota = new JTextField();
		txtNombreMascota.setBounds(230, 135, 100, 20);
		contentPane.add(txtNombreMascota);
		
		lblTipoMascota = new JLabel("Tipo de Mascota*");
		lblTipoMascota.setBounds(18, 165, 149, 20);
		contentPane.add(lblTipoMascota);
		
		cmbTipoMascota = new JComboBox();
		cmbTipoMascota.setModel(new DefaultComboBoxModel(new String[] {"Perro", "Gato", "Ave", "Reptil", "Roedor"}));
		cmbTipoMascota.setBounds(230, 165, 100, 20);
		contentPane.add(cmbTipoMascota);
				
		lblCuotaBase = new JLabel("# Cuota Base*");
		lblCuotaBase.setBounds(18, 195, 149, 20);
		contentPane.add(lblCuotaBase);
		
		txtCuotaBase = new JTextField();
		txtCuotaBase.setBounds(230, 195, 100, 20);
		contentPane.add(txtCuotaBase);
		
		chbBonificado = new JCheckBox("Bonificado");
		chbBonificado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chbBonificado.isSelected())	{
					lblAntiguedad.setText("# Antiguedad*");
				}
				else {
					lblAntiguedad.setText("# Antiguedad");
				}
			}
		});
		chbBonificado.setBounds(18, 225, 100, 20);
		contentPane.add(chbBonificado);
		
		lblAntiguedad = new JLabel("# Antiguedad");
		lblAntiguedad.setBounds(124, 226, 96, 20);
		contentPane.add(lblAntiguedad);
		
		txtAnios = new JTextField();
		txtAnios.setBounds(230, 226, 100, 20);
		contentPane.add(txtAnios);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(validarDatos()) {
					if(chbBonificado.isSelected()) {
						soc = new Bonificado( Integer.parseInt(txtCedula.getText()), txtNombre.getText(), txtNombreMascota.getText(), (String) cmbTipoMascota.getSelectedItem(),
								 Double.parseDouble(txtCuotaBase.getText()), Integer.parseInt(txtAnios.getText()), chbBonificado.isSelected());
						
											}
					else {
						soc = new Socio( Integer.parseInt(txtCedula.getText()), txtNombre.getText(), txtNombreMascota.getText(), (String) cmbTipoMascota.getSelectedItem(),
								Double.parseDouble(txtCuotaBase.getText()));
				
						
					}
					
					if(modifica) {
						coleccion.modificarSocio(soc);
						lblStatus.setForeground(Color.BLUE);
						lblStatus.setText("MODIFICADO con exito");
						
						txtCedula.setText("");
						txtNombre.setText("");
						txtNombreMascota.setText("");
						cmbTipoMascota.setSelectedIndex(0);
						txtCuotaBase.setText("");
						chbBonificado.setSelected(false);
						txtAnios.setText("");
						lblStatus.setForeground(Color.BLUE);
						txtCedula.setEditable(true);
						
					}
					else {
						if(!coleccion.pertenece(soc.getCedula())) {
							coleccion.insertarSocio(soc);
							setCantidad(coleccion.cantidad());
							lblStatus.setForeground(Color.BLUE);
							lblStatus.setText("AGREGADO con exito");
							
							txtCedula.setText("");
							txtNombre.setText("");
							txtNombreMascota.setText("");
							cmbTipoMascota.setSelectedIndex(0);
							txtCuotaBase.setText("");
							chbBonificado.setSelected(false);
							txtAnios.setText("");
							lblStatus.setForeground(Color.BLUE);
							txtCedula.setEditable(true);
						}
						else {
							lblStatus.setForeground(Color.RED);
							lblStatus.setText("EXISTENTE");
						}
					}
				}
				else {
					lblStatus.setForeground(Color.RED);
					lblStatus.setText("Campo " + campo + " invalido");
				}
				
				
			}
			
		});
		btnAceptar.setBounds(73, 279, 80, 20);
		contentPane.add(btnAceptar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaBuscar vent = new VentanaBuscar(coleccion);
				vent.setVisible(true);
				dispose();
				
				
			}
		});
		btnBuscar.setBounds(183, 279, 80, 20);
		contentPane.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCedula.setText("");
				txtNombre.setText("");
				txtNombreMascota.setText("");
				cmbTipoMascota.setSelectedIndex(0);
				txtCuotaBase.setText("");
				chbBonificado.setSelected(false);
				txtAnios.setText("");
				lblStatus.setForeground(Color.BLUE);
				lblStatus.setText("Ingresar nuevo o buscar existente.");
				txtCedula.setEditable(true);
				
			}
		});
		btnLimpiar.setBounds(296, 279, 80, 20);
		contentPane.add(btnLimpiar);
		
		JButton button = new JButton("Cancelar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(407, 279, 80, 20);
		contentPane.add(button);
		
		JTextArea txtrCamposObligatorios = new JTextArea();
		txtrCamposObligatorios.setBackground(SystemColor.control);
		txtrCamposObligatorios.setEditable(false);
		txtrCamposObligatorios.setText("(*) Campos Obligatorios.\r\n(#) Campos Numericos.");
		txtrCamposObligatorios.setBounds(340, 73, 213, 52);
		contentPane.add(txtrCamposObligatorios);
		
		lblStatus = new JTextArea();
		lblStatus.setWrapStyleWord(true);
		lblStatus.setLineWrap(true);
		lblStatus.setBackground(SystemColor.control);
		lblStatus.setEditable(false);
		lblStatus.setForeground(Color.BLUE);
		lblStatus.setText("Ingresar Socio");
		lblStatus.setBounds(18, 25, 253, 29);
		contentPane.add(lblStatus);
		
		lblCantidadDeSocios = new JLabel("Cantidad de socios:");
		lblCantidadDeSocios.setBounds(368, 30, 106, 14);
		contentPane.add(lblCantidadDeSocios);
		
		txtCant = new JTextField();
		txtCant.setBounds(504, 25, 25, 20);
		contentPane.add(txtCant);
		txtCant.setColumns(10);
		
	}
}
