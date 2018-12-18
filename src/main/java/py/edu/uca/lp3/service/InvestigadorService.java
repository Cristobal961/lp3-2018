package py.edu.uca.lp3.service;

import java.util.ArrayList;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Investigador;

public interface InvestigadorService {
	/*
	 * Metodo listarCharla 
	 * 		Recibe como parametro un investigador y lista las charlas
	 * en las que este fue orador, a traves del atributo de charlas del Investigador;
	 */
	public ArrayList<Charla> listarCharla(Investigador investigador);
	
	/*
	 * Metodo listarEvento
	 * 		Recibe como parametro un investigador y lista los eventos
	 * en los que este fue orador de una charla, a traves del atributo de charlas del Investigador;
	 */
	public ArrayList<Evento> listarEvento(Investigador investigador);

}
