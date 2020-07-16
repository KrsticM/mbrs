package generated.controller;

import javax.inject.Inject;

import generated.dto.AbstractOrderDTO;
import generated.model.Order;
import handwritten.mapper.MapperCatalogue;
import handwritten.service.OrderService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

/*
 * Svuda se mapira na full DTO objekat.
 * Anotacija Controller mora biti iznad konkretne klase, da bi se kontroler registrovao.
 */
public class AbstractOrderController {	
	/*
	 * Striktno mora protected da bi videla konkretna klasa.
	 * 
	 * Generalno bi ovde moglo da stoji Abstract, ali ona korisnik neće videti svoje
	 * metode koje doda, bez da uradi castovanje.
	 */
	@Inject
	protected OrderService orderService;
	
	@Inject
	protected MapperCatalogue mapperCatalogue;

	@Get
	public Page<AbstractOrderDTO> getAll(Pageable pageable) {
		return orderService.findAll(pageable).map(el -> mapperCatalogue.getOrderMapper().fullConversion(el));
	}

	@Get("/{id}")
	public AbstractOrderDTO getOne(Integer id){
		return mapperCatalogue.getOrderMapper().fullConversion(orderService.findOne(id));
	}

	@Post
	public AbstractOrderDTO save(@Body Order order) {
		return mapperCatalogue.getOrderMapper().fullConversion(orderService.save(order));
	}

	@Put("/{id}")
	public AbstractOrderDTO edit(Integer id, @Body Order order){
		return mapperCatalogue.getOrderMapper().fullConversion(orderService.update(id, order));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		orderService.delete(id);
	}

}
