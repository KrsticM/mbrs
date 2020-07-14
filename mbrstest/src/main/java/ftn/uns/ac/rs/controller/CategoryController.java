package ftn.uns.ac.rs.controller;

import javax.inject.Inject;

import ftn.uns.ac.rs.dto.CategoryDTO;
import ftn.uns.ac.rs.mapper.CategoryMapper;
import ftn.uns.ac.rs.model.Category;
import ftn.uns.ac.rs.service.CategoryService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

@Controller("/category")
public class CategoryController {
	@Inject
	private CategoryService categoryService;

	@Get
	public Page<CategoryDTO> getAll(Pageable pageable) {
		return categoryService.findAll(pageable).map(CategoryMapper::fullCategoryDTO);
	}

	@Get("/{id}")
	public CategoryDTO getOne(Integer id){
		return CategoryMapper.fullCategoryDTO(categoryService.findOne(id));
	}

	@Post
	public CategoryDTO save(@Body Category category) {
		return CategoryMapper.fullCategoryDTO(categoryService.save(category));
	}

	@Put("/{id}")
	public CategoryDTO edit(Integer id, @Body Category category){
		return CategoryMapper.fullCategoryDTO(categoryService.update(id, category));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		categoryService.delete(id);
	}

}
