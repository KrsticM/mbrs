package ftn.uns.ac.rs.controller;

import javax.inject.Inject;

import ftn.uns.ac.rs.dto.RestaurantDTO;
import ftn.uns.ac.rs.mapper.RestaurantMapper;
import ftn.uns.ac.rs.model.Restaurant;
import hand.service.RestaurantService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

/*
 * Svuda se mapira na full DTO objekat.
 * Anotacija Controller mora biti iznad konkretne klase, da bi se kontroler registrovao.
 */
@Controller("/restaurant")
public abstract class AbstractRestaurantController {
	
	/*
	 * Striktno mora protected da bi videla konkretna klasa.
	 * 
	 * Generalno bi ovde moglo da stoji Abstract, ali ona korisnik neće videti svoje
	 * metode koje doda, bez da uradi castovanje.
	 */
	@Inject
	protected RestaurantService restaurantService;
	
	@Get
	public Page<RestaurantDTO> getAll(Pageable pageable) {
		return restaurantService.findAll(pageable).map(RestaurantMapper::fullRestaurantDTO);		
	}
	
	@Get("/{id}")
	public RestaurantDTO getOne(Integer id){
		return RestaurantMapper.fullRestaurantDTO(restaurantService.findOne(id));
	}

	@Post
	public RestaurantDTO save(@Body Restaurant restaurant) {
		return RestaurantMapper.fullRestaurantDTO(restaurantService.save(restaurant));
	}
	
	@Put("/{id}")
	public RestaurantDTO edit(Integer id, @Body Restaurant restaurant){
		return RestaurantMapper.fullRestaurantDTO(restaurantService.update(id, restaurant));
	}
	
	@Delete("/{id}")
	public void delete(Integer id){
		restaurantService.delete(id);
	}
}
