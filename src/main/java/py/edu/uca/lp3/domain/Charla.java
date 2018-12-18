package py.edu.uca.lp3.domain;

import java.util.ArrayList;

public class Charla {
	private String nombre;
	private ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
	private ArrayList<Persona> listaInscriptos = new ArrayList<Persona>();
	
	
	public ArrayList<Persona> getListaInscriptos() {
		return listaInscriptos;
	}

	public void setListaInscriptos(ArrayList<Persona> listaInscriptos) {
		this.listaInscriptos = listaInscriptos;
	}


	private String expositor;
	private String hora;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Pregunta> getListaPreguntas() {
		return listaPreguntas;
	}
	
	
	
	
	public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
		this.listaPreguntas = listaPreguntas;
	}
	
	public String getExpositor() {
		return expositor;
	}
	
	public void setExpositor(String expositor) {
		this.expositor = expositor;
	}
	
	public String getHora() {
		return hora;
	}
	
	
	public void setHora(String hora) {
		this.hora = hora;
	}

	public Charla(String nombre, ArrayList<Pregunta> listaPreguntas, ArrayList<Persona> listaInscriptos,
			String expositor, String hora) {
		super();
		this.nombre = nombre;
		this.listaPreguntas = listaPreguntas;
		this.listaInscriptos = listaInscriptos;
		this.expositor = expositor;
		this.hora = hora;
	}
	
	
	
}
