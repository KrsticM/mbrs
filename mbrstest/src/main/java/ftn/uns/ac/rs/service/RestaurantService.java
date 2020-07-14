package ftn.uns.ac.rs.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityNotFoundException;

import ftn.uns.ac.rs.model.Restaurant;
import ftn.uns.ac.rs.repository.RestaurantRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class RestaurantService {

	@Inject
	protected RestaurantRepository repo;

	public Page<Restaurant> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	public Restaurant findOne(Integer id){
		Optional<Restaurant> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("No row with the given identifier exists: [" + Restaurant.class.getName() + ":" + id +"]");
	}

	public Restaurant save(Restaurant entity) {
		return repo.update(entity);
	}
	
	public Restaurant update(Integer id, Restaurant newEntity){
		Restaurant entity = findOne(id);
		entity.setName(newEntity.getName());
		entity.setCategory(newEntity.getCategory());
		return save(entity);
	}
	
	public void delete(Integer id){
		Restaurant entity = findOne(id);
		repo.delete(entity);
	}
}
