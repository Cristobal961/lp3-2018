package py.edu.uca.lp3.service;

import java.util.ArrayList;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Persona;

public interface EventoService {
	
	/*
	 *  Medoto agregarCharla 
	 *  	Recibe como parametros un evento y una charla y devuelve un evento con la charla 
	 *  en su lista de charlas
	 *  
	 */
	public Evento agregarCharla(Evento evento, Charla charla );
	
	/*
	 *  Metodo listarExpositores
	 *  	Recibe como parametro un evento y devuelve una lista de todos los expositores de las 
	 *  charlas de los mismos
	 */
	public ArrayList<Persona> listarExpositores(Evento evento);
	
	/*
	 * Metodo inscribirPersona
	 * 		Recibe como parametros un Evento y una Persona y devuelve un evento con la persona 
	 * inscripta en el
	 */
	public Evento inscribirPersona(Evento evento,Persona persona);
	
}
