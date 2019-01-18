package py.edu.uca.lp3.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Investigador;
import py.edu.uca.lp3.service.InvestigadorService;

@Component
public class InvestigadorImpl implements InvestigadorService {

	@Override
	public List<Evento> listarEvento(Investigador investigador) {
		return investigador.getEventos();
	}

	@Override
	public List<Charla> listarCharla(Investigador investigador) {
		return investigador.getCharlas();
	}

}
