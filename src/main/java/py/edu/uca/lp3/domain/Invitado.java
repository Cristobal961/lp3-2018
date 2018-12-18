package py.edu.uca.lp3.domain;

public class Invitado extends Profesional {
	private String Origen;

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public Invitado(String nombre, String apellido, Integer ci, String titulo, String origen) {
		super(nombre, apellido, ci, titulo);
		Origen = origen;
	}
	
}
