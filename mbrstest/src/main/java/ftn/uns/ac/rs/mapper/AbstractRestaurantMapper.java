package ftn.uns.ac.rs.mapper;

import java.util.stream.Collectors;

import ftn.uns.ac.rs.dto.AbstractRestaurantDTO;
import ftn.uns.ac.rs.model.Restaurant;
import hand.dto.RestaurantDTO;

public abstract class AbstractRestaurantMapper{
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public static AbstractRestaurantDTO fullConversion(Restaurant entity) {
		AbstractRestaurantDTO ret = simpleRestaurantDTO(entity);		
		ret.setCategory(AbstractCategoryMapper.simpleConversion(entity.getCategory()));
		ret.setProducts(entity.getProducts().stream().map(AbstractProductMapper::simpleConversion).collect(Collectors.toSet()));
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public static AbstractRestaurantDTO simpleRestaurantDTO(Restaurant restaurant) {
		AbstractRestaurantDTO ret = new RestaurantDTO();
		ret.setId(restaurant.getId());
		ret.setName(restaurant.getName());
		return ret;
	}
}
