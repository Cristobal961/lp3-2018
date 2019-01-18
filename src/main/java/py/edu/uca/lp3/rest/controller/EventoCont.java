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
import py.edu.uca.lp3.domain.Evento;
import py.edu.uca.lp3.domain.Pago;
import py.edu.uca.lp3.domain.Persona;
import py.edu.uca.lp3.domain.Preinscripcion;
import py.edu.uca.lp3.repository.CharlaRepo;
import py.edu.uca.lp3.repository.EventoRepo;
import py.edu.uca.lp3.repository.PersonaRepo;
import py.edu.uca.lp3.service.EventoService;

@RestController
@RequestMapping(value = "/evento")
public class EventoCont {

	@Autowired
	private EventoService eventoService;

	@Autowired
	private EventoRepo eventoRepo;

	@Autowired
	private CharlaRepo charlaRepo;

	@Autowired
	private PersonaRepo personaRepo;

	/*
	 * Metodo mostrar() Retorna una lista de todos los eventos existentes en el
	 * repositorio
	 */
	@RequestMapping(value = "/")
	public ArrayList<Evento> mostrar() {
		return eventoRepo.findAll();
	}

	/*
	 * Metodo mostrarExpositores Recibe como parametro el id de un evento a traves
	 * de PathVariable de la api del servicio REST y retorna una lista de todos las
	 * personas asignadas como expositores a las charlas de dicho evento
	 */
	@RequestMapping(value = "/listar/expositores/id={id}")
	public List<Persona> mostrarExpositores(@PathVariable Integer id) {
		return eventoService.listarExpositores(eventoRepo.findById(id));
	}

	/*
	 * Metodo crearEvento Recibe como parametro un evento, que es cargado por el
	 * metodo "RequestBody" de la api del servicio REST y devuelve una instancia
	 * salvada en la base de datos
	 */
	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public Evento crearEvento(@RequestBody Evento evento) {
		return eventoRepo.save(evento);
	}

	/*
	 * Metodo crearPago Recibe como parametro un evento de tipo Pago, que es cargado
	 * por el metodo "RequestBody" de la api del servicio REST y devuelve una
	 * instancia salvada en la base de datos
	 */
	@RequestMapping(value = "/crear/pago", method = RequestMethod.POST)
	public Pago crearPago(@RequestBody Pago evento) {
		return eventoRepo.save(evento);
	}

	/*
	 * Metodo crearPreinscripcion Recibe como parametro un evento de tipo
	 * Preinscripcion, que es cargado por el metodo "RequestBody" de la api del
	 * servicio REST y devuelve una instancia salvada en la base de datos
	 */
	@RequestMapping(value = "/crear/preinscripcion", method = RequestMethod.POST)
	public Preinscripcion crearPreinscripcion(@RequestBody Preinscripcion evento) {
		return eventoRepo.save(evento);
	}

	/*
	 * Metodo agregarOrganizador Recibe como parametros un organizador que es
	 * obtenido a travez del metodo "RequestBody" y y el nombre de una Persona a
	 * traves del metodo "PathVariable" ambos de la api del servicio REST
	 */
	@RequestMapping(value = "agregar/organizador/evento={nombre}", method = RequestMethod.POST)
	public Evento agregarOrganizador(@RequestBody Persona organizador, @PathVariable String nombre) {
		Evento aux = eventoRepo.findByNombreEvento(nombre).get(0);
		List<Persona> auxPersona = aux.getOrganizador();
		auxPersona.add(personaRepo.save(organizador));
		aux.setOrganizador(auxPersona);
		return eventoRepo.save(aux);
	}

	/*
	 * Metodo agregarCharla Recibe como parametro el nombre de un evento y de una
	 * charla, ambos por metodo PathVariable de la api del servicio REST y retorna
	 * un evento con la charla agregada a su lista de charlas
	 */
	@RequestMapping(value = "agregar/evento={evento}/charla={charla}", method = RequestMethod.POST)
	public Evento agregarCharla(@PathVariable String evento, @PathVariable String charla) {
		Evento auxEvento = eventoRepo.findByNombreEvento(evento).get(0);
		List<Charla> charlas = auxEvento.getListaCharla();
		List<Persona> auxExpositores = auxEvento.getListaExpositores();
		auxExpositores.addAll(charlaRepo.findByNombreCharla(charla).get(0).getExpositor());
		charlas.addAll(charlaRepo.findByNombreCharla(charla));
		auxEvento.setListaCharla(charlas);
		return eventoRepo.save(auxEvento);
	}

	@RequestMapping(value = "/inscribir/persona/evento={evento}/ci={ci}", method = RequestMethod.POST)
	public Evento inscribirPersona(@PathVariable String evento, @PathVariable Integer ci) {
		Evento auxEvento = eventoRepo.findByNombreEvento(evento).get(0);
		Persona auxPersona = personaRepo.findByCi(ci);
		if ((auxEvento = eventoService.inscribirPersona(auxEvento, auxPersona)) == null) {
			return null;
		}
		return eventoRepo.save(auxEvento);
	}
	
	@RequestMapping(value = "/inscribir/persona/evento={evento}/ci={ci}/metodo={metodo}", method = RequestMethod.POST)
	public Pago inscribirAPago(@PathVariable String evento, @PathVariable Integer ci, @PathVariable String metodo) {
		Pago auxEvento = (Pago) eventoRepo.findByNombreEvento(evento).get(0);
		Persona auxPersona = personaRepo.findByCi(ci);
		if(metodo.equals("tarjeta")) {
			eventoService.inscribirPersona(auxEvento, auxPersona, true);
		}else {
			eventoService.inscribirPersona(auxEvento, auxPersona, false);
		}
		return eventoRepo.save(auxEvento);
	}
	
	@RequestMapping(value = "/inscribir/persona/preinscripcion={evento}/ci={ci}", method = RequestMethod.POST)
	public Preinscripcion inscribirAPreinscripcion(@PathVariable String evento, @PathVariable Integer ci) {
		Preinscripcion auxEvento =(Preinscripcion) eventoRepo.findByNombreEvento(evento).get(0);
		Persona auxPersona = personaRepo.findByCi(ci);
		if ((auxEvento = eventoService.inscribirPersona(auxEvento, auxPersona)) == null) {
			return null;
		}
		return eventoRepo.save(auxEvento);
	}
	
	@RequestMapping(value = "/set/lugar/evento={evento}/lugar={lugar}", method = RequestMethod.POST)
	public String setLugar(@PathVariable String evento, @PathVariable String lugar) {
		Evento auxEvento = eventoRepo.findByNombreEvento(evento).get(0);
		List<Evento> eventos = eventoRepo.findAll();
		auxEvento.setLugar(lugar);
		for(int i =0; i<eventos.size();i++) {
			if(eventos.get(i).getLugar()==auxEvento.getLugar() && eventos.get(i).getFecha()==auxEvento.getFecha()
					&& eventos.get(i)!=auxEvento){
				return "Ese lugar ya se encuentra ocupado en la fecha:" + auxEvento.getFecha();
			}
		}
		eventoRepo.save(auxEvento);
		return "Se ha asignado "+ lugar + " a " + evento;
	}

}
