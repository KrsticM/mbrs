package generated.mapper;

import javax.inject.Inject;

import handwritten.feignclient.ProductFeignClient;
import handwritten.feignclient.RestaurantFeignClient;
import handwritten.mapper.OrderItemMapper;
import handwritten.mapper.OrderMapper;
import lombok.Getter;
import lombok.Setter;
/*
 * Katalog svih mapera mora da postoji da katalozi ne bi imali
 * kruzne reference.
 */
@Getter
@Setter
public abstract class AbstractMapperCatalogue {
	/*
	 * Svi maperi
	 * Ne radim inject, jer njima treba AbstractMapperCatalogue, da bi mogli
	 * da koriste ostale mapere i klijente.
	 */
	protected OrderMapper orderMapper = new OrderMapper(this);
	protected OrderItemMapper orderItemMapper = new OrderItemMapper(this);
	
	/*
	 * Svi feign klijenti
	 */
	@Inject
	protected RestaurantFeignClient restaurantFeignClient;
	@Inject
	protected ProductFeignClient productFeignClient;
}
