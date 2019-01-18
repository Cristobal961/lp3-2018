package py.edu.uca.lp3.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Investigador extends Persona {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3179968432646160570L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String area;

	@JsonIgnore
	@ElementCollection
	private List<Evento> eventos = new ArrayList<Evento>();

	@JsonIgnore
	@ElementCollection
	private List<Charla> charlas = new ArrayList<Charla>();

	public List<Charla> getCharlas() {
		return charlas;
	}

	public void setCharlas(List<Charla> charlas) {
		this.charlas = charlas;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Investigador() {
		super();
	}

	public Investigador(String nombre, String apellido, Integer ci, String area) {
		super(nombre, apellido, ci);
		this.area = area;
	}

}
