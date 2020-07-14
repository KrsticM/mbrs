package ftn.uns.ac.rs.mapper;

import ftn.uns.ac.rs.dto.ProductDTO;
import ftn.uns.ac.rs.model.Product;

public class ProductMapper {
	public static ProductDTO fullProductDTO(Product product) {
		ProductDTO ret = simpleProductDTO(product);
		ret.setRestaurant(RestaurantMapper.simpleRestaurantDTO(product.getRestaurant()));
		return ret;
	}
	
	public static ProductDTO simpleProductDTO(Product product) {
		ProductDTO ret = new ProductDTO();
		ret.setId(product.getId());
		ret.setName(product.getName());
		ret.setType(product.getType());
		return ret;
	}
}
