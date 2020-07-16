package generated.repository;

import generated.model.Restaurant;
import io.micronaut.data.repository.PageableRepository;

/*
 * Anotacija mora iznad konkretnog interfejsa, inače ne radi inject.
 */
public interface AbstractRestaurantRepository extends PageableRepository<Restaurant, Integer>{

}
