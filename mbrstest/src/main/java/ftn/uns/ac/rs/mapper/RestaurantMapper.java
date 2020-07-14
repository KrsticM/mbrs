package ftn.uns.ac.rs.mapper;

import java.util.stream.Collectors;

import ftn.uns.ac.rs.dto.RestaurantDTO;
import ftn.uns.ac.rs.model.Restaurant;

public class RestaurantMapper {
	
	public static RestaurantDTO fullRestaurantDTO(Restaurant restaurant) {
		RestaurantDTO ret = simpleRestaurantDTO(restaurant);		
		ret.setCategory(CategoryMapper.simpleCategoryDTO(restaurant.getCategory()));
		ret.setProducts(restaurant.getProducts().stream().map(ProductMapper::simpleProductDTO).collect(Collectors.toSet()));
		return ret;
	}
	
	public static RestaurantDTO simpleRestaurantDTO(Restaurant restaurant) {
		RestaurantDTO ret = new RestaurantDTO();
		ret.setId(restaurant.getId());
		ret.setName(restaurant.getName());
		return ret;
	}
}
