package fp.paises;
import fp.utiles.Checkers; 

public record Idioma(String nombre, Double porcentaje) {
	
	public Idioma {
		
		Checkers.check("El valor del porcentaje debe estar entre 0.0 y 1.0", porcentaje >= 0.0 && porcentaje <= 1.0);
	
	}
}
