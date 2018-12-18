package py.edu.uca.lp3.domain;

public class Investigador extends Persona {
	private String area;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Investigador(String nombre, String apellido, Integer ci, String area) {
		super(nombre, apellido, ci);
		this.area = area;
	}
	

}
