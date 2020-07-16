package generated.controller;

import javax.inject.Inject;

import generated.dto.AbstractRestaurantDTO;
import generated.model.Restaurant;
import hand.mapper.MapperCatalogue;
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
	
	@Inject
	protected MapperCatalogue mapperCatalogue;
	
	@Get
	public Page<AbstractRestaurantDTO> getAll(Pageable pageable) {
		return restaurantService.findAll(pageable).map(el -> mapperCatalogue.getRestaurantMapper().fullConversion(el));		
	}
	
	@Get("/{id}")
	public AbstractRestaurantDTO getOne(Integer id){
		return mapperCatalogue.getRestaurantMapper().fullConversion(restaurantService.findOne(id));
	}

	@Post
	public AbstractRestaurantDTO save(@Body Restaurant restaurant) {
		return mapperCatalogue.getRestaurantMapper().fullConversion(restaurantService.save(restaurant));
	}
	
	@Put("/{id}")
	public AbstractRestaurantDTO edit(Integer id, @Body Restaurant restaurant){
		return mapperCatalogue.getRestaurantMapper().fullConversion(restaurantService.update(id, restaurant));
	}
	
	@Delete("/{id}")
	public void delete(Integer id){
		restaurantService.delete(id);
	}
}
