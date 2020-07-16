package handwritten.mapper;

import javax.inject.Singleton;

import generated.mapper.AbstractMapperCatalogue;
import generated.mapper.AbstractOrderItemMapper;

@Singleton
public class OrderItemMapper extends AbstractOrderItemMapper {

	public OrderItemMapper(AbstractMapperCatalogue mapperCatalogue) {
		super(mapperCatalogue);
	}

}
