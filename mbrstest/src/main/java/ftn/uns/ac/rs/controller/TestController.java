package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.model.Category;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

@Controller
public class TestController {
	@Get 
    @Produces(MediaType.TEXT_PLAIN) 
    public String index() {
        return "Hello World"; 
    }
	
	@Get(value = "lombok")
    @Produces(MediaType.TEXT_PLAIN) 
    public String testLombok() {
        Category cat = new Category(1, "Milica");
        return cat.getName();        
    }
}
