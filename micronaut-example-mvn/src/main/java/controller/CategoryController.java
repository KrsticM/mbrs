package controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpStatus;

@Controller("/category")
public class CategoryController {

    @Get("/")
    public String index() {
        return "Hello";
    }
}