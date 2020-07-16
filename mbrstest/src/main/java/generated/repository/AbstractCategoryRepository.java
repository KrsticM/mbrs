package generated.repository;

import generated.model.Category;
import io.micronaut.data.repository.PageableRepository;

/*
 * Anotacija mora iznad konkretnog interfejsa, inače ne radi inject.
 */
public interface AbstractCategoryRepository extends PageableRepository<Category, Integer>{

}
