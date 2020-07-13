package ftn.uns.ac.rs.controller;

import javax.inject.Inject;

import ftn.uns.ac.rs.dto.RestaurantDTO;
import ftn.uns.ac.rs.model.Restaurant;
import ftn.uns.ac.rs.service.RestaurantService;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller("/restaurant")
public class RestaurantController {
	
	@Inject
	private RestaurantService restaurantService;
	
	@Get
	public Iterable<Restaurant> getRestaurants(Pageable pageable) {
		return restaurantService.findAll(pageable);		
	}
	
	@Get("/{id}")
	public Restaurant getRestaurant(Integer id) {
		return restaurantService.findOne(id);
	}

	@Post
	public Restaurant saveRestaurant(@Body RestaurantDTO restaurantDTO) {
		return restaurantService.add(restaurantDTO);
	}
	
	@Put("/{id}")
	public Restaurant editRestaurant(Integer id, @Body RestaurantDTO restaurantDTO) {
		return restaurantService.update(id, restaurantDTO);
	}
	
	@Delete("/{id}")
	public void deleteRestaurant(Integer id) {
		restaurantService.delete(id);
	}
}
