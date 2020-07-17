package generated.mapper;

import java.util.stream.Collectors;

import generated.dto.AbstractOrderDTO;
import generated.model.Order;
import handwritten.dto.OrderDTO;

public class AbstractOrderMapper {
	
	protected AbstractMapperCatalogue mapperCatalogue;

	public AbstractOrderMapper(AbstractMapperCatalogue mapperCatalogue) {
		this.mapperCatalogue = mapperCatalogue;
	}
	
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public AbstractOrderDTO fullConversion(Order entity) {
		AbstractOrderDTO ret = simpleConversion(entity);
		ret.setItems(entity.getItems().stream().map(el -> mapperCatalogue.getOrderItemMapper().simpleConversion(el)).collect(Collectors.toSet()));
		ret.setRestaurant(mapperCatalogue.getRestaurantFeignClient().getOne(entity.getRestaurant()));
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public AbstractOrderDTO simpleConversion(Order entity) {
		AbstractOrderDTO ret = new OrderDTO();
		ret.setId(entity.getId());
		ret.setDateOrdered(entity.getDateOrdered());
		return ret;
	}
}
