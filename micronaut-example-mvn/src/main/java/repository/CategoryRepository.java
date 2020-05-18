package repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import model.Category;

@Repository
public interface CategoryRepository  extends CrudRepository<Category, Long>{

}
