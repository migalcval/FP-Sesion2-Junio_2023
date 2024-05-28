package fp.paises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import fp.utiles.Checkers;

public class Pais {
	
	//___________Atributos___________________________________________________________________________________
	
	private String codigo;
	private String nombre;
	private Long poblacion;
	private Double area;
	private String capital;
	private Continente contiente;
	private String moneda;
	private List<Idioma> idiomas;
	private Set<String> vecinos;
	
	//________Constructores__________________________________________________________________________________
	
	//------ Constructor C1 ---------------------------------------------------------------------------------
	
	public Pais(String codigo, String nombre, Long poblacion, Double area, String capital, Continente contiente,
			String moneda, List<Idioma> idiomas, Set<String> vecinos) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.area = area;
		this.capital = capital;
		this.contiente = contiente;
		this.moneda = moneda;
		this.idiomas = new ArrayList<>(idiomas);;
		this.vecinos = new HashSet<>(vecinos);
	}
	
	//_______Restricciones____________________________________________________________________________________
	
	public Pais() {
		
		Checkers.check("El valor de la poblacion debe ser mayor o igual a 0", poblacion >= 0);
		Checkers.check("El area debe ser mayor o igual que 0", area >= 0);
		Checkers.check("Si la población es mayor a 0, entonces el país debe tener una capital y una moneda",
				(poblacion > 0 && capital != null && moneda != null) || (poblacion == 0));

	}
	
	//______Getters_and_Setters_________________________________________________________________________________
	
	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Long getPoblacion() {
		return poblacion;
	}

	public Double getArea() {
		return area;
	}

	public String getCapital() {
		return capital;
	}

	public Continente getContiente() {
		return contiente;
	}

	public String getMoneda() {
		return moneda;
	}

	public List<Idioma> getIdiomas() {
		return new ArrayList<>(idiomas);
	}

	public Set<String> getVecinos() {
		return new HashSet<>(vecinos);
	}
	
	public Double getDensidadPoblacion() {
		
		Double densidad = 0.0;
		
		if (area > 0) {
			densidad = poblacion/area;
		}
		
		return densidad;
	}

	public Boolean getAislado() {
		return vecinos.isEmpty();
	}
	
	//______Método_toString()_______________________________________________________________________________
	
	public String toString() {
		return "Pais [codigo=" + codigo + ", nombre=" + nombre + ", poblacion=" + poblacion + ", area=" + area
				+ ", capital=" + capital + ", contiente=" + contiente + ", moneda=" + moneda + ", idiomas=" + idiomas
				+ ", vecinos=" + vecinos + "]";
	}
	
	//______Método_hashCode()_and_equals_____________________________________________________________________
	
	public int hashCode() {
		return Objects.hash(codigo);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	//_______Otras_operaciones__________________________________________________________________________________
	
	public Boolean sonTodosVecinos(Set<Pais> paises) {
		
		boolean res = true;
		
		for (Pais p : paises) {
			if (!getVecinos().contains(p.getCodigo())) {
				res = false;
			}
			
		}
		
		return res;
	}
	
}
