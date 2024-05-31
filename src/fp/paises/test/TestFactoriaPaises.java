package fp.paises.test;

import java.util.List;

import fp.paises.FactoriaPaises;
import fp.paises.Pais;

public class TestFactoriaPaises {

	public static void main(String[] args) {
		testLeeViajes("data/paises.csv");
	}
			
	private static void testLeeViajes(String rutaFichero) {
		
		System.out.println("\n------------- TestLeeViajes -------------");
		List<Pais> paises=FactoriaPaises.leePais(rutaFichero);
		System.out.println(" Pais: ");
		
		for(Pais p: paises) {
			System.out.println(p);
			
		}
	}
}


