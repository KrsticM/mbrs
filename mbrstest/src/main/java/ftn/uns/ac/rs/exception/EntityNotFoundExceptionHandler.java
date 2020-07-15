package ftn.uns.ac.rs.exception;

import javax.inject.Singleton;
import javax.persistence.EntityNotFoundException;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;


/*
 * Ova klasa ide kakva jeste.
 */
@SuppressWarnings("rawtypes")
@Produces
@Singleton 
@Requires(classes = {EntityNotFoundException.class, ExceptionHandler.class})
public class EntityNotFoundExceptionHandler implements ExceptionHandler<EntityNotFoundException, HttpResponse>{

	@Override
	public HttpResponse handle(HttpRequest request, EntityNotFoundException exception) {
		return HttpResponse.notFound(exception.getMessage());
	}

}
