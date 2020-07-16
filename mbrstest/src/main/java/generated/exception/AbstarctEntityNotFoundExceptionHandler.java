package generated.exception;

import javax.persistence.EntityNotFoundException;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.server.exceptions.ExceptionHandler;


/*
 * Ova klasa ide kakva jeste.
 * Ona handla sve greske kada se pokusa get sa pogresnim kljucem.
 * Takodje handla i kada na primer, hocemo da dodatmo restoran sa nepostojeceom kategorijom.
 */
@SuppressWarnings("rawtypes")
public abstract class AbstarctEntityNotFoundExceptionHandler implements ExceptionHandler<EntityNotFoundException, HttpResponse>{

	@Override
	public HttpResponse handle(HttpRequest request, EntityNotFoundException exception) {
		return HttpResponse.notFound(exception.getMessage());
	}

}
