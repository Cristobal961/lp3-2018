package py.edu.uca.lp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Charla implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -160197677534197710L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombreCharla;

	@ElementCollection
	private List<Pregunta> listaPreguntas = new ArrayList<Pregunta>();

	@ElementCollection
	private List<Persona> listaInscriptos = new ArrayList<Persona>();

	@ElementCollection
	private List<Persona> expositor = new ArrayList<Persona>();

	private String hora;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCharla() {
		return nombreCharla;
	}

	public void setNombreCharla(String nombreCharla) {
		this.nombreCharla = nombreCharla;
	}

	public List<Persona> getListaInscriptos() {
		return listaInscriptos;
	}

	public void setListaInscriptos(List<Persona> listaInscriptos) {
		this.listaInscriptos = listaInscriptos;
	}

	public List<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}

	public void setListaPreguntas(List<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}

	public List<Persona> getExpositor() {
		return expositor;
	}

	public void setExpositor(List<Persona> expositor) {
		this.expositor = expositor;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Charla() {
		super();
	}

	public Charla(String nombre, String hora) {
		super();
		this.nombreCharla = nombre;
		this.hora = hora;
	}

}
