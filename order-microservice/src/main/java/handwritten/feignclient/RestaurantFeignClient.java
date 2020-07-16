package handwritten.feignclient;

import generated.feignclient.AbstractRestaurantFeignClient;
import io.micronaut.http.client.annotation.Client;

@Client(id = "mbrstest", path = "/restaurant")
public interface RestaurantFeignClient extends AbstractRestaurantFeignClient {

}
