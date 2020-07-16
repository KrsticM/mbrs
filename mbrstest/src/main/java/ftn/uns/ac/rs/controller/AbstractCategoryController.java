package ftn.uns.ac.rs.controller;

import javax.inject.Inject;

import ftn.uns.ac.rs.dto.AbstractCategoryDTO;
import ftn.uns.ac.rs.model.Category;
import hand.mapper.CategoryMapper;
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
	
	@Get
	public Page<AbstractCategoryDTO> getAll(Pageable pageable) {
		return categoryService.findAll(pageable).map(CategoryMapper::fullConversion);
	}

	@Get("/{id}")
	public AbstractCategoryDTO getOne(Integer id){
		return CategoryMapper.fullConversion(categoryService.findOne(id));
	}

	@Post
	public AbstractCategoryDTO save(@Body Category category) {
		return CategoryMapper.fullConversion(categoryService.save(category));
	}

	@Put("/{id}")
	public AbstractCategoryDTO edit(Integer id, @Body Category category){
		return CategoryMapper.fullConversion(categoryService.update(id, category));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		categoryService.delete(id);
	}

}
