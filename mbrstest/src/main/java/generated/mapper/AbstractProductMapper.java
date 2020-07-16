package generated.mapper;

import generated.dto.AbstractProductDTO;
import generated.model.Product;
import hand.dto.ProductDTO;

public abstract class AbstractProductMapper implements Mapper<Product, AbstractProductDTO>{	
	protected AbstractMapperCatalogue mapperCatalogue;
	
	public AbstractProductMapper(AbstractMapperCatalogue mapperCatalogue) {
		this.mapperCatalogue = mapperCatalogue;
	}
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public AbstractProductDTO fullConversion(Product entity) {
		AbstractProductDTO ret = simpleConversion(entity);
		ret.setRestaurant(mapperCatalogue.getRestaurantMapper().simpleConversion(entity.getRestaurant()));
		return ret;
	}
	
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public AbstractProductDTO simpleConversion(Product entity) {
		AbstractProductDTO ret = new ProductDTO();
		ret.setId(entity.getId());
		ret.setName(entity.getName());
		ret.setType(entity.getType());
		return ret;
	}
}
