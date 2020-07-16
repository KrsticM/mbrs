package generated.mapper;

import java.util.stream.Collectors;

import generated.dto.AbstractRestaurantDTO;
import generated.model.Restaurant;
import hand.dto.RestaurantDTO;

public abstract class AbstractRestaurantMapper implements Mapper<Restaurant,AbstractRestaurantDTO>{	
	protected AbstractMapperCatalogue mapperCatalogue;
	
	public AbstractRestaurantMapper(AbstractMapperCatalogue mapperCatalogue) {
		this.mapperCatalogue = mapperCatalogue;
	}
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public AbstractRestaurantDTO fullConversion(Restaurant entity) {
		AbstractRestaurantDTO ret = simpleConversion(entity);		
		ret.setCategory(mapperCatalogue.getCategoryMapper().simpleConversion(entity.getCategory()));
		ret.setProducts(entity.getProducts().stream().map(el -> mapperCatalogue.getProductMapper().simpleConversion(el)).collect(Collectors.toSet()));
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public AbstractRestaurantDTO simpleConversion(Restaurant restaurant) {
		AbstractRestaurantDTO ret = new RestaurantDTO();
		ret.setId(restaurant.getId());
		ret.setName(restaurant.getName());
		return ret;
	}
}
