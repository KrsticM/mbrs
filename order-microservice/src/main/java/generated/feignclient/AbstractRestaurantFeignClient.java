package generated.feignclient;

import handwritten.dto.FeignRestaurantDTO;
import io.micronaut.http.annotation.Get;

/*
 * Anotacija za client mora na onom koji se koristi, da bi
 * se registrovao.
 */
public interface AbstractRestaurantFeignClient {
	@Get("/{id}")
    public FeignRestaurantDTO getOne(Integer id);
}
