package py.edu.uca.lp3.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.service.PreguntaService;

@Component
public class PreguntaImpl implements PreguntaService {

	@Override
	public Pregunta thumbsUp(Pregunta pregunta) {
		Integer positivos = pregunta.getUpvote();
		pregunta.setUpvote(positivos);
		return pregunta;
	}

	@Override
	public Pregunta thumbsDown(Pregunta pregunta) {
		Integer negativos = pregunta.getDownvote();
		pregunta.setDownvote(negativos);
		return pregunta;
	}

	@Override
	public String mostrarVotos(Pregunta pregunta) {
		String votos = "";
		votos = "Pregunta: " + pregunta.getPregunta() + "\n" + "Votos negativos: " + pregunta.getDownvote().toString()
				+ "\n" + "Votos positivos: " + pregunta.getUpvote().toString() + "\n";
		return votos;
	}

	@Override
	public Pregunta comentariosHabilitar(Pregunta pregunta) {
		Boolean comentarios = pregunta.getComentarios();
		pregunta.setComentarios(comentarios);
		return pregunta;
	}

	@Override
	public Pregunta cargarComentario(Pregunta pregunta, String comentario) {
		List<String> comentarios = pregunta.getListaComentarios();
		if(pregunta.getComentarios()) {
			comentarios.add(comentario);
			return pregunta;
		}
		return null;
	}

}
