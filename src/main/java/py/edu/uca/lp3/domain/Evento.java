package py.edu.uca.lp3.domain;

import java.util.ArrayList;

import py.edu.uca.lp3.service.EventoService;



public class Evento implements EventoService{
	private String nombre;
	private String fecha;
	private String lugar;
	private ArrayList<Charla> listaCharla = new ArrayList<Charla>();
	//private ArrayList<Persona> listaExpositores = new ArrayList<Persona>();
	private Persona organizador;
	private ArrayList<Persona> listaParticipantes = new ArrayList<Persona>();
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public ArrayList<Charla> getListaCharla() {
		return listaCharla;
	}
	
	public void setListaCharla(ArrayList<Charla> listaCharla) {
		this.listaCharla = listaCharla;
	}
	
	public Persona getOrganizador() {
		return organizador;
	}
	
	public void setOrganizador(Persona organizador) {
		this.organizador = organizador;
	}
	

	public ArrayList<Persona> getListaParticipantes() {
		return listaParticipantes;
	}
	

	public void setListaParticipantes(ArrayList<Persona> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}
	

	public String getLugar() {
		return lugar;
	}
	

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Evento(String nombre, String fecha, String lugar, Persona organizador) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.lugar = lugar;
		this.organizador = organizador;
	}

	


	@Override
	public Evento inscribirPersona(Evento evento, Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Evento agregarCharla(Evento evento, Charla charla) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Persona> listarExpositores(Evento evento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
