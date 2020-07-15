package ftn.uns.ac.rs.mapper;

import ftn.uns.ac.rs.dto.ProductDTO;
import ftn.uns.ac.rs.model.Product;

public class ProductMapper {
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public static ProductDTO fullProductDTO(Product product) {
		ProductDTO ret = simpleProductDTO(product);
		ret.setRestaurant(RestaurantMapper.simpleRestaurantDTO(product.getRestaurant()));
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public static ProductDTO simpleProductDTO(Product product) {
		ProductDTO ret = new ProductDTO();
		ret.setId(product.getId());
		ret.setName(product.getName());
		ret.setType(product.getType());
		return ret;
	}
}
