package hand.exception;

import javax.inject.Singleton;

import ftn.uns.ac.rs.exception.AbstractPersistenceExceptionHandler;
import io.micronaut.http.annotation.Produces;

@Produces
@Singleton
public class PersistenceExceptionHandler extends AbstractPersistenceExceptionHandler {

}
