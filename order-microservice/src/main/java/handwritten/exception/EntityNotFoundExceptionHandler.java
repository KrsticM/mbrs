package handwritten.exception;

import javax.inject.Singleton;

import generated.exception.AbstarctEntityNotFoundExceptionHandler;
import io.micronaut.http.annotation.Produces;

@Produces
@Singleton
public class EntityNotFoundExceptionHandler extends AbstarctEntityNotFoundExceptionHandler {

}
