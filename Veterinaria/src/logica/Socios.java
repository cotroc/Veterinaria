package logica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;

public class Socios {
	
	private int porcentaje;
	private String driver;
	private String base;
	private String usuario;
	private String password;
	
	public Socios() {
		try { 
			driver = "com.mysql.jdbc.Driver";		 
			Class.forName(driver);
			
			base = "jdbc:mysql://localhost:3306/veterinaria";
			usuario = "root";
			password = "admin";
		   }catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} 	   
		
	}
	
	public Socio buscarSocio(int cedula) {
		Socio s = null;
		try
		  {
			Connection con = DriverManager.getConnection(base, usuario, password);
			   String query = "SELECT * FROM socios WHERE cedula =" + cedula ;
			   PreparedStatement stmt = con.prepareStatement(query);
			   ResultSet rs = stmt.executeQuery(query);
			   if(rs.next())
			   {
				   if(rs.getBoolean("bonif")) {
						 s = new  Bonificado(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("nombreMascota"),
									rs.getString("tipoMascota"), rs.getInt("cuotaBase"), rs.getInt("antiguedad"), rs.getBoolean("bonif"));
					
					 }
					 else {
						 s = new  Socio(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("nombreMascota"),
									rs.getString("tipoMascota"), rs.getInt("cuotaBase"));
						 
					 }
			   }
			   rs.close();
			   con.close();
		  }
			
		  catch (SQLException e) {
				
				e.printStackTrace();
			}
		return s;
	}
	
	public void configurarValores(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public int getPorcentaje(){
		return this.porcentaje;
	}
	
	public int cantidad() {
		int cantidad = 0; 
		try
	  {
		   Connection con = DriverManager.getConnection(base, usuario, password);
		   String query = "SELECT COUNT(*) FROM socios";
		   Statement stmt = con.createStatement();
		   ResultSet rs = stmt.executeQuery(query);
		   rs.next();
		   cantidad = rs.getInt(1); 
		   rs.close();
		   con.close();
	  }
		
	  catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cantidad;
	}
	
	public boolean pertenece(int cedula) {
		boolean resu = false;
		  try
		  {
			   Connection con = DriverManager.getConnection(base, usuario, password);
			   String query = "SELECT * FROM socios WHERE cedula =" + cedula;
			   PreparedStatement stmt = con.prepareStatement(query);
			   ResultSet rs = stmt.executeQuery(query);
			   if(rs.next())
			   {
				  resu = true;
			   }
			   rs.close();
			   con.close();
		  }
		  catch (SQLException e) {
				
				e.printStackTrace();
			}
		  return resu;
	}
	
	public void insertarSocio(Socio r) {
		 try {	  
				
				Connection con = DriverManager.getConnection(base, usuario, password);
				 String query = "INSERT INTO socios VALUES(0,?,?,?,?,?,?,?);";
				 
			     PreparedStatement ps = con.prepareStatement(query);
			     ps.setInt(1, r.getCedula());
			     ps.setString(2, r.getNombre());
			     ps.setString(3, r.getNombreMascota());
			     ps.setString(4, r.getTipoMascota());
			     ps.setDouble(5, r.getCuotaBase());
			    
			     if(r instanceof Bonificado) {
			    	 ps.setBoolean(6, ((Bonificado) r).getBonificado());
			    	 ps.setDouble(7, ((Bonificado) r).getAntiguedad());
			     }
			     else {
			    	 ps.setDouble(6, 0);
					 ps.setBoolean(7, false);
			     }
			     			     
			     ps.executeUpdate();
			     ps.close();
			     con.close();
			  }  catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Ya existe el Socio");
				return;
				//e.printStackTrace();
			}
	}
	
	public void modificarSocio(Socio r) {
		try {	  
			
			Connection con = DriverManager.getConnection(base, usuario, password);
			 String query = "update socios SET nombre = ?, nombreMascota = ?, tipoMascota = ?,cuotaBase = ?, bonif = ?, antiguedad = ?, where cedula ="+ r.getCedula()+";";

		     PreparedStatement ps = con.prepareStatement(query);
		     ps.setString(1, r.getNombre());
		     ps.setString(2, r.getNombreMascota());
		     ps.setString(3, r.getTipoMascota());
		     ps.setDouble(4, r.getCuotaBase());
		     		    
		     if(r instanceof Bonificado) {
		    	 ps.setBoolean(5, ((Bonificado) r).getBonificado());
		    	 ps.setDouble(6, ((Bonificado) r).getAntiguedad());
		     }
		     else {
		    	 ps.setDouble(5, 0);
				 ps.setBoolean(6, false);
		     }
		     			     
		     ps.executeUpdate();
		     ps.close();
		     con.close();
		  }  catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en la base consulta de actualizacion.");
			return;
			//e.printStackTrace();
		}
	}
	
	public double totalCuota() {
		double total = 0;
		Socio soc;
		try
		  {
			   Connection con = DriverManager.getConnection(base, usuario, password);
			   String query = "SELECT * FROM socios";
			   Statement stmt = con.createStatement();
			   ResultSet rs = stmt.executeQuery(query);
			  
			   while(rs.next()) {
				
				
				   if(rs.getBoolean("bonif")) {
					 soc = new  Bonificado(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("nombreMascota"),
								rs.getString("tipoMascota"), rs.getInt("cuotaBase"), rs.getInt("antiguedad"), rs.getBoolean("bonif"));
				
				 }
				 else {
					 soc = new  Socio(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("nombreMascota"),
								rs.getString("tipoMascota"), rs.getInt("cuotaBase"));
					 
				 }
				 
				   
				 
				 total = total + soc.calcularCuota(porcentaje);
			  }
			   rs.close();
			   con.close();
		  }
			
		  catch (SQLException e) {
				
				e.printStackTrace();
			}
		return total;
	}
	
	public String listarSocios () {
		Socio soc;
		String listasoc = "";
		try
		  {
			   Connection con = DriverManager.getConnection(base, usuario, password);
			   String query = "SELECT * FROM socios";
			   Statement stmt = con.createStatement();
			   ResultSet rs = stmt.executeQuery(query);
			  
			   while(rs.next()) {
				 if(rs.getBoolean("bonif")) {
					 soc = new  Bonificado(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("nombreMascota"),
								rs.getString("tipoMascota"), rs.getInt("cuotaBase"), rs.getInt("antiguedad"), rs.getBoolean("bonif"));
				
				 }
				 else {
					 soc = new  Socio(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("nombreMascota"),
								rs.getString("tipoMascota"), rs.getInt("cuotaBase"));
					 
				 }
				 listasoc = listasoc + "\n" + soc.datosBasicos();
			  }
			   rs.close();
			   con.close();
		  }
			
		  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		/*ListIterator<Socio> it = colec.listIterator();
		while(it.hasNext()) {
			Socio s = it.next();
			listasoc = listasoc + "\n" + s.datosBasicos();
		}
		*/
		return listasoc;
	}
	
}
