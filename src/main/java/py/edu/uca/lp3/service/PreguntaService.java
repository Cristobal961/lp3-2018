package py.edu.uca.lp3.service;

import py.edu.uca.lp3.domain.Pregunta;

public interface PreguntaService {
	/*
	 * Metodo thumbsUp
	 * 		Recibe como parametro una pregunta y devuelve una pregunta con un voto positivo agregado
	 * al atributo de votos positivos de la pregunta
	 */
	public Pregunta thumbsUp(Pregunta pregunta);
	
	/*
	 * Metodo thumbsDown
	 * 		Recibe como parametro una pregunta y devuelve una pregunta con un voto negativo agregado
	 * al atributo de votos negativos de la pregunta
	 */
	public Pregunta thumbsDown(Pregunta pregunta);
	
	/*
	 * Metodo mostratVotos
	 * 		Recibe como parametro una pregunta y devuelve un string:
	 * 	"Se tienen x votos positivos e y votos negativos"
	 */
	public String mostrarVotos(Pregunta pregunta);
	
	/*
	 * Metodo comentariosHabilitar
	 * 		Recibe como parametro una pregunta y modifica la bandera para habilitar o deshabilitar
	 * los comentarios
	 */
	public Pregunta comentariosHabilitar(Pregunta pregunta);
	
}
