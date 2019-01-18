package py.edu.uca.lp3.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pago extends Evento {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8070575472959019050L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Integer precio;

	@ElementCollection
	private List<Persona> listaTarjeta = new ArrayList<Persona>();

	@ElementCollection
	private List<Persona> listaEfectivo = new ArrayList<Persona>();

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public List<Persona> getListaTarjeta() {
		return listaTarjeta;
	}

	public void setListaTarjeta(List<Persona> listaTarjeta) {
		this.listaTarjeta = listaTarjeta;
	}

	public List<Persona> getListaEfectivo() {
		return listaEfectivo;
	}

	public void setListaEfectivo(List<Persona> listaEfectivo) {
		this.listaEfectivo = listaEfectivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pago() {
		super();
	}

	public Pago(String nombre, String fecha, Integer precio) {
		super(nombre, fecha);
		this.precio = precio;
	}

}
