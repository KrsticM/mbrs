package generated.mapper;

import generated.dto.AbstractOrderItemDTO;
import generated.model.OrderItem;
import handwritten.dto.OrderItemDTO;

public class AbstractOrderItemMapper implements Mapper<OrderItem, AbstractOrderItemDTO>{

	protected AbstractMapperCatalogue mapperCatalogue;

	public AbstractOrderItemMapper(AbstractMapperCatalogue mapperCatalogue) {
		this.mapperCatalogue = mapperCatalogue;
	}

	/*
	 * Ovde se setuju sva polja koja su složeni tip. Svi oni se setuju na basic DTO
	 * verziju (dakle bez drugih složenih tipova), jer jedino tako znamo da sigurno
	 * nema kružnih referenci.
	 */
	public AbstractOrderItemDTO fullConversion(OrderItem entity) {
		AbstractOrderItemDTO ret = simpleConversion(entity);
		ret.setOrder(mapperCatalogue.getOrderMapper().simpleConversion(entity.getOrder()));
		ret.setProduct(mapperCatalogue.getProductFeignClient().getOne(entity.getProduct()));
		return ret;
	}

	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se
	 * setuje). Zatim se setuju sva polja koja su prosti tip.
	 */
	public AbstractOrderItemDTO simpleConversion(OrderItem entity) {
		AbstractOrderItemDTO ret = new OrderItemDTO();
		ret.setId(entity.getId());
		ret.setQuantity(entity.getQuantity());
		return ret;
	}
}
