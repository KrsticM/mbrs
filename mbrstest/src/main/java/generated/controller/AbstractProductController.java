package generated.controller;

import javax.inject.Inject;

import generated.dto.AbstractProductDTO;
import generated.model.Product;
import hand.mapper.MapperCatalogue;
import hand.service.ProductService;
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
public abstract class AbstractProductController {
	/*
	 * Striktno mora protected da bi videla konkretna klasa.
	 * 
	 * Generalno bi ovde moglo da stoji Abstract, ali ona korisnik neće videti svoje
	 * metode koje doda, bez da uradi castovanje.
	 */
	@Inject
	protected ProductService productService;
	
	@Inject
	protected MapperCatalogue mapperCatalogue;

	@Get
	public Page<AbstractProductDTO> getAll(Pageable pageable) {
		return productService.findAll(pageable).map(el -> mapperCatalogue.getProductMapper().simpleConversion(el));
	}

	@Get("/{id}")
	public AbstractProductDTO getOne(Integer id){
		return mapperCatalogue.getProductMapper().fullConversion(productService.findOne(id));
	}

	@Post
	public AbstractProductDTO save(@Body Product product) {
		return mapperCatalogue.getProductMapper().fullConversion(productService.save(product));
	}

	@Put("/{id}")
	public AbstractProductDTO edit(Integer id, @Body Product product){
		return mapperCatalogue.getProductMapper().fullConversion(productService.update(id, product));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		productService.delete(id);
	}

}
