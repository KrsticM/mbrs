package ftn.uns.ac.rs.mapper;

import java.util.stream.Collectors;

import ftn.uns.ac.rs.dto.RestaurantDTO;
import ftn.uns.ac.rs.model.Restaurant;

public class RestaurantMapper {
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public static RestaurantDTO fullRestaurantDTO(Restaurant restaurant) {
		RestaurantDTO ret = simpleRestaurantDTO(restaurant);		
		ret.setCategory(CategoryMapper.simpleCategoryDTO(restaurant.getCategory()));
		ret.setProducts(restaurant.getProducts().stream().map(ProductMapper::simpleProductDTO).collect(Collectors.toSet()));
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public static RestaurantDTO simpleRestaurantDTO(Restaurant restaurant) {
		RestaurantDTO ret = new RestaurantDTO();
		ret.setId(restaurant.getId());
		ret.setName(restaurant.getName());
		return ret;
	}
}
