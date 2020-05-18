package ftn.uns.ac.rs.controller;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

import ftn.uns.ac.rs.model.Category;
import ftn.uns.ac.rs.service.CategoryService;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller("/category")
public class CategoryController {
	@Inject
	private CategoryService categoryService;

	@Get
	public Iterable<Category> getCategories(Pageable pageable) {
		return categoryService.findAll(pageable);
	}

	@Get("/{id}")
	public Category getCategory(Integer id) {

		return categoryService.findOne(id);
	}

	@Post
	public Category saveCategory(@Body Category category) {

		return categoryService.save(category);
	}

	@Put("/{id}")
	public Category editCategory(Integer id, @Body Category category)
			throws IllegalAccessException, InvocationTargetException {
		return categoryService.update(id, category);
	}
}
