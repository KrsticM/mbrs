package controller;

import javax.inject.Inject;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Put;
import model.Category;
import service.CategoryService;

@Controller("/category")
public class CategoryController {

//	protected final CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) { 
//        this.categoryService = categoryService;
//    }
	
	@Inject
	private CategoryService categoryService;	
	
    @Get("/{id}") 
    public Category getCategory(Long id) {
		Category category =  categoryService.getCategory(id);
		return category;           
    }
   
    @Get("/")
    public Iterable<Category> getCategories() {
    	Iterable<Category> ret = categoryService.getCategories();
    	return ret;
    }
    
    @Put("/{id}")
    public Category editCategory(Long id, @Body Category dto) {
    	Category ret = categoryService.editCategory(id, dto);
    	return ret;    	
    }
    
}