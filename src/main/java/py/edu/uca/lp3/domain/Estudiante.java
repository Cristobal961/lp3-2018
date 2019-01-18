package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudiante extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = 660216802024747864L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String universidad;
	private String facultad;
	private String matricula;

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Estudiante() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estudiante(String nombre, String apellido, Integer ci, String universidad, String facultad,
			String matricula) {
		super(nombre, apellido, ci);
		this.universidad = universidad;
		this.facultad = facultad;
		this.matricula = matricula;
	}
}
