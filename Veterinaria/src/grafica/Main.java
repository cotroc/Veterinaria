package grafica;

import logica.Socios;

public class Main {

	public static void main(String[] args) {
		
  Socios s = new Socios();
  VentanaPrincipal v = new VentanaPrincipal(s);
  v.setVisible(true);
	}

}
