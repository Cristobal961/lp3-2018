package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profesor extends Profesional {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6100545238899413928L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String catedra;
	private String universidad;
	private String facultad;

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Profesor() {
		super();
	}

	public Profesor(String nombre, String apellido, Integer ci, String titulo, String catedra, String universidad,
			String facultad) {
		super(nombre, apellido, ci, titulo);
		this.catedra = catedra;
		this.universidad = universidad;
		this.facultad = facultad;
	}

}
