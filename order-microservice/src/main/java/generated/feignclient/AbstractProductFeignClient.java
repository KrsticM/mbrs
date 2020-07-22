package generated.feignclient;

import handwritten.dto.feign.FeignProductDTO;
import io.micronaut.http.annotation.Get;

/*
 * Anotacija za client mora na onom koji se koristi, da bi
 * se registrovao.
 */
public interface AbstractProductFeignClient {
	@Get("/{id}")
    public FeignProductDTO getOne(Integer id);
}
