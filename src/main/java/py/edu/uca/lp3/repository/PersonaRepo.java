package py.edu.uca.lp3.repository;

import java.util.ArrayList;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import py.edu.uca.lp3.domain.Persona;

@RepositoryRestResource(collectionResourceRel = "personaRepo", path = "personaRepo")
public interface PersonaRepo extends PagingAndSortingRepository<Persona, Long> {
	Persona findByCi(Integer ci);

	ArrayList<Persona> findAll();
}
