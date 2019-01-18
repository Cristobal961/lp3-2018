package py.edu.uca.lp3.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Pregunta;
@RepositoryRestResource(collectionResourceRel = "preguntaRepo", path = "preguntaRepo")
public interface PreguntaRepo extends PagingAndSortingRepository<Pregunta, Long> {
	Pregunta findById(Integer id);
	List<Pregunta> findAll();
	List<Pregunta> findByFecha(String fecha);
}
