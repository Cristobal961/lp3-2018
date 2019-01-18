package py.edu.uca.lp3.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.service.CharlaService;

@Component
public class CharlaImpl implements CharlaService {

	@Override
	public Charla agregarPregunta(Charla charla, Pregunta pregunta) {
		List<Pregunta> preguntas = charla.getListaPreguntas();
		preguntas.add(pregunta);
		charla.setListaPreguntas(preguntas);
		return charla;
	}

	@Override
	public Charla agregarExpositor(Charla charla, Persona persona) {
		List<Persona> auxExpositor = charla.getExpositor();
		auxExpositor.add(persona);
		charla.setExpositor(auxExpositor);
		return charla;
	}

	@Override
	public ArrayList<Pregunta> listarPregunta(Charla charla) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Charla eliminarPregunta(Charla charla, Integer id) {
		List<Pregunta> preguntas = charla.getListaPreguntas();
		Predicate<Pregunta> predicado = (Pregunta pregunta) -> pregunta.getId() == id;
		preguntas.removeIf(predicado);
		charla.setListaPreguntas(preguntas);
		return charla;
	}

	// TODO modificar para la parte extra del trabajo
	@Override
	public Charla inscribirPersona(Charla charla, Persona persona) {
		List<Persona> inscriptos = charla.getListaInscriptos();
		inscriptos.add(persona);
		charla.setListaInscriptos(inscriptos);
		return charla;
	}

	@Override
	public Charla crearCharla(String nombre, String hora) {
		return new Charla(nombre, hora);
	}

	@Override
	public String tipoExpositor(Charla charla) {
		String expositores = "";
		for (int i = 0; i < charla.getExpositor().size(); i++) {
			if (charla.getExpositor().get(i).getClass().getSimpleName().equals("Persona")) {
				expositores = expositores + charla.getExpositor().get(i).getNombre() + " : " + "Sin ocupacion" + "\n";
				continue;
			}
			expositores = expositores + charla.getExpositor().get(i).getNombre() + " : "
					+ charla.getExpositor().get(i).getClass().getSimpleName() + "\n";
		}
		return expositores;
	}

}
