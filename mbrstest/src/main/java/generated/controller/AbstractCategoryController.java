package generated.controller;

import javax.inject.Inject;

import generated.dto.AbstractCategoryDTO;
import generated.model.Category;
import hand.mapper.MapperCatalogue;
import hand.service.CategoryService;
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
public abstract class AbstractCategoryController {
	/*
	 * Striktno mora protected da bi videla konkretna klasa.
	 * 
	 * Generalno bi ovde moglo da stoji Abstract, ali ona korisnik neće videti svoje
	 * metode koje doda, bez da uradi castovanje.
	 */
	@Inject
	protected CategoryService categoryService;
	
	@Inject
	protected MapperCatalogue mapperCatalogue;
	
	@Get
	public Page<AbstractCategoryDTO> getAll(Pageable pageable) {
		return categoryService.findAll(pageable).map(el -> mapperCatalogue.getCategoryMapper().fullConversion(el));
	}

	@Get("/{id}")
	public AbstractCategoryDTO getOne(Integer id){
		return mapperCatalogue.getCategoryMapper().fullConversion(categoryService.findOne(id));
	}

	@Post
	public AbstractCategoryDTO save(@Body Category category) {
		return mapperCatalogue.getCategoryMapper().fullConversion(categoryService.save(category));
	}

	@Put("/{id}")
	public AbstractCategoryDTO edit(Integer id, @Body Category category){
		return mapperCatalogue.getCategoryMapper().fullConversion(categoryService.update(id, category));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		categoryService.delete(id);
	}

}
