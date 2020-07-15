package ftn.uns.ac.rs.exception;

import javax.inject.Singleton;
import javax.persistence.PersistenceException;

import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;

/*
 * Ova klasa ide kakva jeste.
 * Ona handla narusena ogranicenja nad bazom - unique i nullable.
 */
@SuppressWarnings("rawtypes")
@Produces
@Singleton 
@Requires(classes = {PersistenceException.class, ExceptionHandler.class})
public class PersistenceExceptionHandler implements ExceptionHandler<PersistenceException, HttpResponse>{

	@Override
	public HttpResponse handle(HttpRequest request, PersistenceException exception) {		
		return HttpResponse.badRequest(exception.getCause().getCause().getMessage());
	}

}
