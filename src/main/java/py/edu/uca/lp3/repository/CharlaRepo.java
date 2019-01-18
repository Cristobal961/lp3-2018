package py.edu.uca.lp3.repository;

import java.util.ArrayList;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import py.edu.uca.lp3.domain.Charla;

@RepositoryRestResource(collectionResourceRel = "charlaRepo", path = "charlaRepo")
public interface CharlaRepo extends PagingAndSortingRepository<Charla, Long> {

	ArrayList<Charla> findByNombreCharla(String nombre);

	ArrayList<Charla> findAll();

}
