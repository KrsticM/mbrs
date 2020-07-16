package hand.exception;

import javax.inject.Singleton;

import ftn.uns.ac.rs.exception.AbstarctEntityNotFoundExceptionHandler;
import io.micronaut.http.annotation.Produces;

@Produces
@Singleton
public class EntityNotFoundExceptionHandler extends AbstarctEntityNotFoundExceptionHandler {

}
