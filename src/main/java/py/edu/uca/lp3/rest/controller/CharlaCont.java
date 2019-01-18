
package py.edu.uca.lp3.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Charla;
import py.edu.uca.lp3.domain.Investigador;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.repository.CharlaRepo;
import py.edu.uca.lp3.repository.PersonaRepo;
import py.edu.uca.lp3.repository.PreguntaRepo;
import py.edu.uca.lp3.service.CharlaService;

@RestController
@RequestMapping(value = "/charla")
public class CharlaCont {

	@Autowired
	private CharlaService charlaService;
	@Autowired
	private CharlaRepo charlaRepo;
	@Autowired
	private PersonaRepo personaRepo;
	@Autowired
	private PreguntaRepo preguntaRepo;

	@RequestMapping(value = "/")
	public ArrayList<Charla> mostrar() {
		return charlaRepo.findAll();
	}


	@RequestMapping(value = "/agregar/expositor/charla={nombre}/ci={ci}")
	public Charla agregarExpositor(@PathVariable String nombre, @PathVariable Integer ci) {
		Charla charla = charlaRepo.findByNombreCharla(nombre).get(0);
		List<Persona> auxExpositor = charlaRepo.findByNombreCharla(nombre).get(0).getExpositor();
		auxExpositor.add(personaRepo.findByCi(ci));
		charla.setExpositor(auxExpositor);
		return charlaRepo.save(charla);
	}
	
	@RequestMapping(value = "/agregar/pregunta/charla={charla}/id={id}")
	public Charla agregarPregunta(@PathVariable String charla, @PathVariable Integer id){
		Charla auxCharla = charlaRepo.findByNombreCharla(charla).get(0);
		Pregunta auxPregunta = preguntaRepo.findById(id);
		return charlaRepo.save(charlaService.agregarPregunta(auxCharla, auxPregunta));
	}

	@RequestMapping(value = "/crear/nombre={nombre}/hora={hora}", method = RequestMethod.POST)
	public Charla crearCharla(@PathVariable String nombre, @PathVariable String hora) {
		Charla aux = charlaService.crearCharla(nombre, hora);
		return charlaRepo.save(aux);
	}

	@RequestMapping(value = "/inscribir/charla={nombre}/ci={ci}", method = RequestMethod.POST)
	public Charla inscribirPersona(@PathVariable String nombre, @PathVariable Integer ci) {
		Charla auxCharla = charlaRepo.findByNombreCharla(nombre).get(0);
		Persona auxPersona = personaRepo.findByCi(ci);
		List<Persona> auxInscriptos = auxCharla.getListaInscriptos();
		auxInscriptos.add(auxPersona);
		auxCharla.setListaInscriptos(auxInscriptos);
		if (auxPersona.getClass().getSimpleName().equals("Investigador")) {
			Investigador auxInvestigador = (Investigador) auxPersona;
			List<Charla> charlas = auxInvestigador.getCharlas();
			charlas.add(auxCharla);
			auxInvestigador.setCharlas(charlas);
			personaRepo.save(auxInvestigador);
		}
		return charlaRepo.save(auxCharla);
	}

	@RequestMapping(value = "/tipoExpositor/charla={charla}")
	public String tipoExpositor(@PathVariable String charla) {
		return charlaService.tipoExpositor(charlaRepo.findByNombreCharla(charla).get(0));
	}

}
