package py.edu.uca.lp3.domain;

public class Estudiante extends Persona {
	private String universidad;
	private String facultad;
	private String matricula;
	
	public String getUniversidad() 
	{
		return universidad;
	}
	
	public void setUniversidad(String universidad)
	{
		this.universidad = universidad;
	}
	
	public String getFacultad()
	{
		return facultad;
	}
	
	public void setFacultad(String facultad)
	{
		this.facultad = facultad;
	}
	
	public String getMatricula()
	{
		return matricula;
	}
	
	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}

	public Estudiante(String nombre, String apellido, Integer ci, String universidad, String facultad,
			String matricula) {
		super(nombre, apellido, ci);
		this.universidad = universidad;
		this.facultad = facultad;
		this.matricula = matricula;
	}
}
