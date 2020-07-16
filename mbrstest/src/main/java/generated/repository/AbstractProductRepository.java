package generated.repository;

import generated.model.Product;
import io.micronaut.data.repository.PageableRepository;

/*
 * Anotacija mora iznad konkretnog interfejsa, inače ne radi inject.
 */
public interface AbstractProductRepository extends PageableRepository<Product, Integer> {

}
