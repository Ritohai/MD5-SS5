package ra.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ra.entity.Todo;

@Repository
public interface TodoRespository extends CrudRepository<Todo, Integer> {
}
