package logica;

import java.sql.ResultSet;

public class Socio {
	private String nombre;
	private int cedula;
	private String nombreMascota;
	private String tipoMascota;
	private double cuotaBase;
	
	public Socio(int cedula, String nombre, String nombreMascota, String tipoMascota, double cuotaBase){
		this.nombre = nombre;
		this.cedula = cedula;
		this.nombreMascota = nombreMascota;
		this.tipoMascota = tipoMascota;
		this.cuotaBase = cuotaBase;
	}
	
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getCedula(){
		return cedula;
	}
	
	public void setNombre(int cedula){
		this.cedula = cedula;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getTipoMascota() {
		return tipoMascota;
	}

	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;
	}

	public double getCuotaBase() {
		return cuotaBase;
	}

	public void setCuotaBase(double cuotaBase) {
		this.cuotaBase = cuotaBase;
	}
	
	public double calcularCuota (int porcentaje) {
		double cuota;
		cuota = getCuotaBase() - (porcentaje*100)/getCuotaBase();
		return cuota;
	}
	
	public String datosBasicos() {
		String datos;
			datos = cedula + " - " + nombre + " - " + nombreMascota + " - " + tipoMascota + " - " + cuotaBase;
		return datos;
	}
	
	
}
