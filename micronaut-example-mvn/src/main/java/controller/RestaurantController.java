package controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Controller("/restaurant")
public class RestaurantController {

    @Get("/")
    public HttpStatus index() {
        return HttpStatus.OK;
    }
}