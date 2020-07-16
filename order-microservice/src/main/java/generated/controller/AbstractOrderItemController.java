package generated.controller;

import javax.inject.Inject;

import generated.dto.AbstractOrderItemDTO;
import generated.model.OrderItem;
import handwritten.mapper.MapperCatalogue;
import handwritten.service.OrderItemService;
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
public class AbstractOrderItemController {
	/*
	 * Striktno mora protected da bi videla konkretna klasa.
	 * 
	 * Generalno bi ovde moglo da stoji Abstract, ali ona korisnik neće videti svoje
	 * metode koje doda, bez da uradi castovanje.
	 */
	@Inject
	protected OrderItemService orderItemService;
	
	@Inject
	protected MapperCatalogue mapperCatalogue;

	@Get
	public Page<AbstractOrderItemDTO> getAll(Pageable pageable) {
		return orderItemService.findAll(pageable).map(el -> mapperCatalogue.getOrderItemMapper().fullConversion(el));
	}

	@Get("/{id}")
	public AbstractOrderItemDTO getOne(Integer id){
		return mapperCatalogue.getOrderItemMapper().fullConversion(orderItemService.findOne(id));
	}

	@Post
	public AbstractOrderItemDTO save(@Body OrderItem orderItem) {
		return mapperCatalogue.getOrderItemMapper().fullConversion(orderItemService.save(orderItem));
	}

	@Put("/{id}")
	public AbstractOrderItemDTO edit(Integer id, @Body OrderItem orderItem){
		return mapperCatalogue.getOrderItemMapper().fullConversion(orderItemService.update(id, orderItem));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		orderItemService.delete(id);
	}
}
