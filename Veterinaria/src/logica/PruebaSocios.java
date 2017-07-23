package logica;
//import java.util.*;
public class PruebaSocios {

	
	public static void main(String[] args) {
		
		
		Socios socios;
		
		socios = new Socios();
		
		Socio uno = new Socio( 9123, "hector", "teo", "teocirraptor", 100);
		//Socio dos = new Bonificado( 8124, "andrea", "seiya", "seiyacirraptor", 100, 3);
		//Socio tres = new Bonificado( 7125, "ade", "nana", "nanamontana", 100, 5);
		
		
		/*
		socios.insertarSocio(uno);
		socios.insertarSocio(dos);
		socios.insertarSocio(tres);
		
		System.out.println(socios.cantidad());
		System.out.println(socios.listarSocios());
		
		socios.configurarValores(10);
		System.out.println(socios.totalCuota());
		
		System.out.println(socios.pertenece(uno.getCedula()));
		*/
		
		System.out.println(socios.totalCuota());

	}
	
	

}
