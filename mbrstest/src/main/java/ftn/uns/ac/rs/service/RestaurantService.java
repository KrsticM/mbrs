package ftn.uns.ac.rs.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import ftn.uns.ac.rs.dto.RestaurantDTO;
import ftn.uns.ac.rs.model.Category;
import ftn.uns.ac.rs.model.Restaurant;
import ftn.uns.ac.rs.repository.RestaurantRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class RestaurantService {

	@Inject
	protected RestaurantRepository repo;

	@Inject
	private CategoryService categoryService;

	public Page<Restaurant> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	/**
	 * Finds restaurant with given id
	 * 
	 * @param id
	 * @return
	 */
	public Restaurant findOne(Integer id) {
		Optional<Restaurant> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public Restaurant save(Restaurant entity) {
		return repo.update(entity);
	}

	public Restaurant add(RestaurantDTO dto) {
		Category category = categoryService.findOne(dto.getCategoryId());
		Restaurant restaurant = new Restaurant();
		restaurant.setName(dto.getName());
		restaurant.setCategory(category);
		return save(restaurant);
	}
	
	public Restaurant update(Integer id, RestaurantDTO dto) {
		Category category = categoryService.findOne(dto.getCategoryId());
		Restaurant entity = findOne(id);
		entity.setName(dto.getName());
		entity.setCategory(category);
		return save(entity);
	}
	
	public void delete(Integer id) {
		Restaurant entity = findOne(id);
		repo.delete(entity);
	}
}
