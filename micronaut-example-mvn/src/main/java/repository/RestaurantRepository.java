package repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import model.Restaurant;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

}
