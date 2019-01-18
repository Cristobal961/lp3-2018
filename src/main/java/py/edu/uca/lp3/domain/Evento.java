package py.edu.uca.lp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1489307220894888219L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombreEvento;
	private String fecha;
	private String lugar;

	@ElementCollection
	private List<Charla> listaCharla = new ArrayList<Charla>();

	@ElementCollection
	private List<Persona> listaExpositores = new ArrayList<Persona>();

	@ElementCollection
	private List<Persona> organizador = new ArrayList<Persona>();

	@ElementCollection
	private List<Persona> listaParticipantes = new ArrayList<Persona>();

	public List<Persona> getListaExpositores() {
		return listaExpositores;
	}

	public void setListaExpositores(ArrayList<Persona> listaExpositores) {
		this.listaExpositores = listaExpositores;
	}

	public String getNombre() {
		return nombreEvento;
	}

	public void setNombre(String nombre) {
		this.nombreEvento = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Charla> getListaCharla() {
		return listaCharla;
	}

	public void setListaCharla(List<Charla> listaCharla) {
		this.listaCharla = listaCharla;
	}

	public List<Persona> getOrganizador() {
		return organizador;
	}

	public void setOrganizador(List<Persona> organizador) {
		this.organizador = organizador;
	}

	public List<Persona> getListaParticipantes() {
		return listaParticipantes;
	}

	public void setListaParticipantes(List<Persona> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Evento() {
		super();
	}

	public Evento(String nombre, String fecha) {
		super();
		this.nombreEvento = nombre;
		this.fecha = fecha;
	}
}
