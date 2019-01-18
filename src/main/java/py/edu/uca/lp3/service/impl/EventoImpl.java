package py.edu.uca.lp3.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Pago;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.Preinscripcion;
import py.edu.uca.lp3.service.EventoService;

@Component
public class EventoImpl implements EventoService {

	@Override
	public Evento agregarCharla(Evento evento, Charla charla) {
		List<Charla> charlas = evento.getListaCharla();
		charlas.add(charla);
		evento.setListaCharla(charlas);
		return evento;
	}

	@Override
	public List<Persona> listarExpositores(Evento evento) {
		return evento.getListaExpositores();
	}

	@Override
	public Evento inscribirPersona(Evento evento, Persona persona) {
		if (evento.getClass().getSimpleName().equals("Pago")) {
			Pago auxPago = (Pago) evento;
			if (auxPago.getListaEfectivo().contains(persona) || auxPago.getListaTarjeta().contains(persona)) {
				List<Persona> auxPersona = evento.getListaParticipantes();
				auxPersona.add(persona);
				evento.setListaParticipantes(auxPersona);
				return evento;
			}
			return null;
		} else if (evento.getClass().getSimpleName().equals("Preinscripcion")) {
			Preinscripcion auxPreinscripcion = (Preinscripcion) evento;
			if (auxPreinscripcion.getListaInscriptos().contains(persona)) {
				List<Persona> auxPersona = evento.getListaParticipantes();
				auxPersona.add(persona);
				evento.setListaParticipantes(auxPersona);
				return evento;
			}
			return null;
		}
		List<Persona> auxPersona = evento.getListaParticipantes();
		auxPersona.add(persona);
		evento.setListaParticipantes(auxPersona);
		return evento;
	}

	public Pago inscribirPersona(Pago evento, Persona persona, Boolean metodo){
		if (metodo) {
			List<Persona> auxPersona = evento.getListaTarjeta();
			auxPersona.add(persona);
			evento.setListaTarjeta(auxPersona);
			return evento;
		} else {
			List<Persona> auxPersona = evento.getListaEfectivo();
			auxPersona.add(persona);
			evento.setListaEfectivo(auxPersona);
			return evento;
		}
	}

	public Preinscripcion inscribirPersona(Preinscripcion evento, Persona persona) {
		List<Persona> auxPersona = evento.getListaInscriptos();
		auxPersona.add(persona);
		evento.setListaInscriptos(auxPersona);
		return evento;
	}

}
