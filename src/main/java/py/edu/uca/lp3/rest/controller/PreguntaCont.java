package py.edu.uca.lp3.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import py.edu.uca.lp3.domain.Pregunta;
import py.edu.uca.lp3.repository.PreguntaRepo;
import py.edu.uca.lp3.service.PreguntaService;

@RestController
@RequestMapping(value = "/pregunta")
public class PreguntaCont {
	@Autowired
	PreguntaRepo preguntaRepo;
	@Autowired
	PreguntaService preguntaService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<Pregunta> listarPreguntas() {
		return preguntaRepo.findAll();
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public Pregunta crearPregunta(@RequestBody Pregunta pregunta) {
		return preguntaRepo.save(pregunta);
	}

	@RequestMapping(value = "/findById/id={id}", method = RequestMethod.GET)
	public Pregunta findById(@PathVariable Integer id) {
		return preguntaRepo.findById(id);
	}

	@RequestMapping(value = "/findByFecha/fecha={fecha}", method = RequestMethod.GET)
	public List<Pregunta> findByFecha(@PathVariable String fecha) {
		return preguntaRepo.findByFecha(fecha);
	}

	@RequestMapping(value = "/thumbsUp/id={id}", method = RequestMethod.POST)
	public Pregunta thumbsUp(@PathVariable Integer id) {
		Pregunta aux = preguntaRepo.findById(id);
		aux.setUpvote(aux.getUpvote() + 1);
		return preguntaRepo.save(aux);
	}

	@RequestMapping(value = "/thumbsDown/id={id}", method = RequestMethod.POST)
	public Pregunta thumbsDown(@PathVariable Integer id) {
		Pregunta aux = preguntaRepo.findById(id);
		aux.setDownvote(aux.getDownvote() + 1);
		return preguntaRepo.save(aux);
	}

	@RequestMapping(value = "/mostrar/votos/id={id}", method = RequestMethod.GET)
	public String mostrarVotos(@PathVariable Integer id) {
		Pregunta aux = preguntaRepo.findById(id);
		aux.setDownvote(aux.getDownvote() + 1);
		return preguntaService.mostrarVotos(aux);
	}

	@RequestMapping(value = "/agregar/comentario/id={id}", method = RequestMethod.POST)
	public Pregunta agregarComentario(@PathVariable Integer id, @RequestBody String comentario) {
		Pregunta auxPregunta = preguntaRepo.findById(id);
		return preguntaRepo.save(preguntaService.cargarComentario(auxPregunta, comentario));
	}
	@RequestMapping(value= "/listar/comentarios/id={id}")
	public List<String> listarComentarios(@PathVariable Integer id){
		Pregunta auxPregunta = preguntaRepo.findById(id);
		return auxPregunta.getListaComentarios();
	}
	@RequestMapping(value = "/comentarios/toggle/id={id}")
	public String toggleComentarios(@PathVariable Integer id){
		Pregunta auxPregunta = preguntaRepo.findById(id);
		auxPregunta.setComentarios(!auxPregunta.getComentarios());
		return preguntaRepo.save(auxPregunta).getComentarios()?"Comentarios Habilitados \n":"Comentarios Deshabilitados \n";
	}
}
