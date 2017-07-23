package logica;

public class Bonificado extends Socio{
	
	private int antiguedad;
	private boolean bonif;
	
	public Bonificado( int cedula, String nombre, String nombreMascota, String tipoMascota, double cuotaBase, int antiguedad, boolean bonif) {
		super(cedula, nombre, nombreMascota, tipoMascota, cuotaBase);
		this.antiguedad = antiguedad;
		this.bonif = bonif;
		
	}
	
	public int getAntiguedad() {
		return antiguedad;
	}
	
	public void setAntiguedad(int antiguedad)	{
		this.antiguedad = antiguedad;
	}
	
	public boolean getBonificado() {
		return this.bonif;
	}
	
	public void setBonificado(boolean bonif) {
		this.bonif = bonif;
	}
	
	public double calcularCuota (int porcentaje) {
		double cuota;
		double porcenTotal;
		porcenTotal = (double) porcentaje + (2 * antiguedad);
		cuota = getCuotaBase() - (porcenTotal*100)/getCuotaBase();
		return cuota;
	}
	
	public String datosBasicos() {
		String datos = super.datosBasicos();
		datos = datos + " - " + antiguedad;
		return datos;
	}

}
