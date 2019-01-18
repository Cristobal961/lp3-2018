package py.edu.uca.lp3.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invitado extends Profesional {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5620961088606562561L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String origen;

	public String getOrigen() {
		return origen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOrigen(String origen) {
		origen = origen;
	}

	public Invitado() {
		super();
	}

	public Invitado(String nombre, String apellido, Integer ci, String titulo, String origen) {
		super(nombre, apellido, ci, titulo);
		origen = origen;
	}

}
