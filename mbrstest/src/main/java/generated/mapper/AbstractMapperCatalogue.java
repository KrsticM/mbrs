package generated.mapper;

import hand.mapper.CategoryMapper;
import hand.mapper.ProductMapper;
import hand.mapper.RestaurantMapper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractMapperCatalogue {
	protected CategoryMapper categoryMapper = new CategoryMapper(this);
	protected RestaurantMapper restaurantMapper = new RestaurantMapper(this);
	protected ProductMapper productMapper = new ProductMapper(this);
}
