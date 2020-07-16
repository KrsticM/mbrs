package handwritten.mapper;

import javax.inject.Singleton;

import generated.mapper.AbstractMapperCatalogue;
import generated.mapper.AbstractOrderMapper;

@Singleton
public class OrderMapper extends AbstractOrderMapper {

	public OrderMapper(AbstractMapperCatalogue mapperCatalogue) {
		super(mapperCatalogue);
	}

}
