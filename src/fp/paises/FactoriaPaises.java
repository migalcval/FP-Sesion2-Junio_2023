package fp.paises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import fp.utiles.Checkers;
import fp.utiles.Ficheros;


public class FactoriaPaises {
	
	public static List<Pais> leePais(String rutaFichero){
		
		Checkers.checkNoNull(rutaFichero);
		List<String> lineas = Ficheros.leeFichero("Error al leer el fichero", rutaFichero);
		lineas.remove(0);
		
		List<Pais> res = new ArrayList<Pais>();
		
		for(String linea:lineas) {
			Pais p = parseaPais(linea);
			res.add(p);
		}
		return res;
	}
	
	public static Pais parseaPais(String cadena) {
		
		String [] trozos = cadena.split(";");
		Checkers.check("Formato no valido", trozos.length == 9);
		String codigo = trozos[0].trim();
		String nombre = trozos[1].trim();
		Long poblacion = Long.valueOf(trozos[2].trim());
		Double area = Double.valueOf(trozos[3].trim());
		String capital = parseaNull(trozos[4]);
		Continente continente = parseaContinente(trozos[5].trim());
		String moneda = parseaNull(trozos[6].trim());
		List<Idioma> idiomas = parseaIdiomas(trozos[7].trim());
		Set<String> vecinos = parseaVecinos(trozos[8].trim());
		
		return new Pais(codigo, nombre, poblacion, area, capital, continente, moneda, idiomas, vecinos);
		
	}
	
	private static String parseaNull(String cadena) {
		
		String res = null;
		if (!cadena.trim().isEmpty()) {
			res = cadena.trim();
		}
		
		return res;
	}
	
	private static Continente parseaContinente(String cadena) {
		
		switch (cadena) {
			case "AF": return Continente.AFRICA;
			case "AN": return Continente.ANTARTICA;
			case "AS": return Continente.ASIA;
			case "EU": return Continente.EUROPE;
			case "NA": return Continente.NORTH_AMERICA;
			case "OC": return Continente.OCEANIA;
			case "SA": return Continente.SOUTH_AMERICA;
			
			default: return null;
		}
	}
	
	private static List<Idioma> parseaIdiomas(String cadena) {
		
		List<Idioma> res = new ArrayList<>();
		
		if (!cadena.trim().isEmpty()) {
			String [] trozos = cadena.split(",");
			for (String s : trozos) {
				res.add(parseaIdioma(s));
			}
		}
		return res;	
	}
	
	private static Idioma parseaIdioma(String cadena) {
		
		String [] trozos = cadena.split(":");
		Checkers.check("Formato no valido", trozos.length == 2);
		String moneda = trozos[0].trim();
		Double porcentaje = Double.valueOf(trozos[1].trim());
		
		return new Idioma(moneda, porcentaje);
		
	}
	
	private static Set<String> parseaVecinos(String cadena) {
		
		Set<String> res = new HashSet<>();
		
		if (!cadena.trim().isEmpty()) {
			String [] trozos = cadena.split(",");
			for (String s : trozos) {
				res.add(s);
			}
		}
		return res;
	}
}
