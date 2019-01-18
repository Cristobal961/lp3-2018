package py.edu.uca.lp3.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Estudiante;
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Investigador;
import py.edu.uca.lp3.domain.Invitado;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.Profesional;
import py.edu.uca.lp3.domain.Profesor;
import py.edu.uca.lp3.repository.PersonaRepo;
import py.edu.uca.lp3.service.InvestigadorService;

@RestController
@RequestMapping(value = "/persona")
public class PersonaCont {

	@Autowired
	private PersonaRepo personaRepo;

	@Autowired
	private InvestigadorService investigadorService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	ArrayList<Persona> listarPersona() {
		return personaRepo.findAll();
	}

	@RequestMapping(value = "/investigador/listar/eventos/ci={ci}", method = RequestMethod.GET)
	List<Evento> listarEventos(@PathVariable Integer ci) {
		if (personaRepo.findByCi(ci).getClass().getSimpleName().equals("Investigador")) {
			Investigador aux = (Investigador) personaRepo.findByCi(ci);
			return investigadorService.listarEvento(aux);
		}
		return null;
	}

	@RequestMapping(value = "/investigador/listar/charlas/ci={ci}", method = RequestMethod.GET)
	List<Charla> listarCharlas(@PathVariable Integer ci) {
		if (personaRepo.findByCi(ci).getClass().getSimpleName().equals("Investigador")) {
			Investigador aux = (Investigador) personaRepo.findByCi(ci);
			return investigadorService.listarCharla(aux);
		}
		return null;
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	Persona crearPersona(@RequestBody Persona persona) {
		return personaRepo.save(persona);
	}

	@RequestMapping(value = "/crear/estudiante", method = RequestMethod.POST)
	Estudiante crearEstudiante(@RequestBody Estudiante persona) {
		return personaRepo.save(persona);
	}

	@RequestMapping(value = "/crear/investigador", method = RequestMethod.POST)
	Investigador crearInvestigador(@RequestBody Investigador persona) {
		return personaRepo.save(persona);
	}

	@RequestMapping(value = "/crear/invitado", method = RequestMethod.POST)
	Invitado crearInvitado(@RequestBody Invitado persona) {
		return personaRepo.save(persona);
	}

	@RequestMapping(value = "/crear/profesional", method = RequestMethod.POST)
	Profesional crearProfesional(@RequestBody Profesional persona) {
		return personaRepo.save(persona);
	}

	@RequestMapping(value = "/crear/profesor", method = RequestMethod.POST)
	Profesor crearProfesor(@RequestBody Profesor persona) {
		return personaRepo.save(persona);
	}
	@RequestMapping(value = "/mostrar/universidad/ci={ci}", method = RequestMethod.GET)
	String mostrarUniversidad(@PathVariable Integer ci){
		if(personaRepo.findByCi(ci).getClass().getSimpleName().equals("Estudiante")){
		Estudiante estudiante =(Estudiante)personaRepo.findByCi(ci);
		String universidad = "Universidad: "+estudiante.getUniversidad()+"\n"
		+"Facultad: "+ estudiante.getFacultad()+"\n";
		return universidad;
		}else {
			return "Esta persona no es un estudiante";
		}
	}

}
