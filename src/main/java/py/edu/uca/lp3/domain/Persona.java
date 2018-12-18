package py.edu.uca.lp3.domain;

public class Persona {
	private String nombre;
	private String apellido;
	private Integer ci;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getCi() {
		return ci;
	}
	
	public void setCi(Integer ci) {
		this.ci = ci;
	}

	public Persona(String nombre, String apellido, Integer ci) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.ci = ci;
	}
	
	
}
