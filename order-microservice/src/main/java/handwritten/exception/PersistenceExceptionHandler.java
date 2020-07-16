package handwritten.exception;

import javax.inject.Singleton;

import generated.exception.AbstractPersistenceExceptionHandler;
import io.micronaut.http.annotation.Produces;

@Produces
@Singleton
public class PersistenceExceptionHandler extends AbstractPersistenceExceptionHandler {

}
