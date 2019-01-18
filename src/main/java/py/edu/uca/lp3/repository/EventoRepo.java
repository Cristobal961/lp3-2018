package py.edu.uca.lp3.repository;

import java.util.ArrayList;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.Evento;

@RepositoryRestResource(collectionResourceRel = "eventoRepo", path = "eventoRepo")
public interface EventoRepo extends PagingAndSortingRepository<Evento, Long> {

	ArrayList<Evento> findByNombreEvento(String nombre);

	Evento findById(long id);

	ArrayList<Evento> findAll();

}
