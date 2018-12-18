package py.edu.uca.lp3.domain;

import java.util.ArrayList;

public class Preinscripcion extends Evento {
	
	private ArrayList<Persona> listaInscriptos = new ArrayList<Persona>();
	
	public ArrayList<Persona> getListaInscriptos() {
		return listaInscriptos;
	}

	public void setListaInscriptos(ArrayList<Persona> listaInscriptos) {
		this.listaInscriptos = listaInscriptos;
	}

	public Preinscripcion(String nombre, String fecha, String lugar, Persona organizador) {
		super(nombre, fecha, lugar, organizador);
	}
	
	

	
	
	
}
