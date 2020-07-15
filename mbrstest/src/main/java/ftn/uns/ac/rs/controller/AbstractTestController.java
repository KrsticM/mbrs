package ftn.uns.ac.rs.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;

/*
 * Ovo se ne generiše, ovo je test za nas, da proverimo radi li kontroler.
 */
public abstract class AbstractTestController {
	@Get 
    @Produces(MediaType.TEXT_PLAIN) 
    public String index() {
        return "Hello World"; 
    }
}
