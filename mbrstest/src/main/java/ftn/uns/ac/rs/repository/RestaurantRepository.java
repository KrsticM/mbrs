package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.model.Restaurant;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface RestaurantRepository extends PageableRepository<Restaurant, Integer>{

}
