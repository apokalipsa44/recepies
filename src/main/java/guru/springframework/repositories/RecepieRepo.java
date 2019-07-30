package guru.springframework.repositories;

import guru.springframework.domain.Recepie;
import org.springframework.data.repository.CrudRepository;

public interface RecepieRepo extends CrudRepository<Recepie, Long> {
}
