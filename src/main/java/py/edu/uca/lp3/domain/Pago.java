package py.edu.uca.lp3.domain;

import java.util.ArrayList;

public class Pago extends Preinscripcion {
	private Integer precio;
	private ArrayList<Persona> listaTarjeta = new ArrayList<Persona>();
	private ArrayList<Persona> listaEfectivo = new ArrayList<Persona>();
	
	public Integer getPrecio() {
		return precio;
	}
	
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	public ArrayList<Persona> getListaTarjeta() {
		return listaTarjeta;
	}
	
	public void setListaTarjeta(ArrayList<Persona> listaTarjeta) {
		this.listaTarjeta = listaTarjeta;
	}
	
	public ArrayList<Persona> getListaEfectivo() {
		return listaEfectivo;
	}
	
	public void setListaEfectivo(ArrayList<Persona> listaEfectivo) {
		this.listaEfectivo = listaEfectivo;
	}

	public Pago(String nombre, String fecha, String lugar, Persona organizador, Integer precio) {
		super(nombre, fecha, lugar, organizador);
		this.precio = precio;
	}

}
