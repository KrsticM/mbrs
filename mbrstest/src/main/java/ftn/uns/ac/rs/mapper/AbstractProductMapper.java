package ftn.uns.ac.rs.mapper;

import ftn.uns.ac.rs.dto.AbstractProductDTO;
import ftn.uns.ac.rs.model.Product;
import hand.dto.ProductDTO;

public abstract class AbstractProductMapper{
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public static AbstractProductDTO fullConversion(Product entity) {
		AbstractProductDTO ret = simpleConversion(entity);
		ret.setRestaurant(AbstractRestaurantMapper.simpleRestaurantDTO(entity.getRestaurant()));
		return ret;
	}
	
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public static AbstractProductDTO simpleConversion(Product entity) {
		AbstractProductDTO ret = new ProductDTO();
		ret.setId(entity.getId());
		ret.setName(entity.getName());
		ret.setType(entity.getType());
		return ret;
	}
}
