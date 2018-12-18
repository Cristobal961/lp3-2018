package py.edu.uca.lp3.domain;

public class Profesional extends Persona {
	private String Titulo;
	

	public String getTitulo() {
		return Titulo;
	}
	
	public void setTitulo(String titulo) {
		Titulo = titulo;
	}

	public Profesional(String nombre, String apellido, Integer ci, String titulo) {
		super(nombre, apellido, ci);
		Titulo = titulo;
	}
	
	
}
