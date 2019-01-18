package py.edu.uca.lp3.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Preinscripcion extends Evento {
	/**
	 * 
	 */
	private static final long serialVersionUID = -311994317437367942L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ElementCollection
	private List<Persona> listaInscriptos = new ArrayList<Persona>();

	public List<Persona> getListaInscriptos() {
		return listaInscriptos;
	}

	public void setListaInscriptos(List<Persona> listaInscriptos) {
		this.listaInscriptos = listaInscriptos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Preinscripcion() {
		super();
	}

	public Preinscripcion(String nombre, String fecha) {
		super(nombre, fecha);
	}

}
