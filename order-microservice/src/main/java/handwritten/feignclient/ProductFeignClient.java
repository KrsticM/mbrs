package handwritten.feignclient;

import generated.feignclient.AbstractProductFeignClient;
import io.micronaut.http.client.annotation.Client;

@Client(id = "mbrstest", path = "/product")
public interface ProductFeignClient extends AbstractProductFeignClient {

}
