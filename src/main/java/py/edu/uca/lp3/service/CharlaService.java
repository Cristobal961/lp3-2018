package py.edu.uca.lp3.service;

import java.util.ArrayList;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.Pregunta;

public interface CharlaService {
	
	/*
	 * Metodo agregarPregunta
	 *		Recibe como parametro una Charla y una Pregunta y agrega la pregunta a la lista de
	 * preguntas de la charla.
	*/
	public Charla agregarPregunta(Charla charla, Pregunta pregunta);
	
	/*
	 * Metodo agregarExpositor
	 *		Recibe como parametro una Charla y una Persona y hace un set en el atributo Expositor de
	 * la charla con la Persona pasada como parametro
	 */
	public Charla agregarExpositor(Charla charla, Persona persona);
	
	/*
	 * Metodo listarPregunta
	 * 		Recibe como parametro una Charla y devuelve una lista de todas las preguntas hechas 
	 * sobre esa charla
	 */
	public ArrayList<Pregunta> listarPregunta(Charla charla);
	
	/*
	 * Metodo eliminarPregunta
	 *		Recibe como parametro una Charla y un id y elimina la pregunta correspondiente
	 * al id de la  lista de preguntas de la charla.
	*/
	public Charla eliminarPregunta(Charla charla, Integer id);
	
	/*
	 * Metodo inscribirPersona
	 * 		Recibe como parametros una Charla y una Persona y devuelve una charla con la persona 
	 * inscripta en ella
	 */
	public Charla inscribirPersona(Charla charla,Persona persona);

}
