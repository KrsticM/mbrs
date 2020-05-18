package controller;

import javax.inject.Inject;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
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
    	System.out.println("usao u kontroler");
		Category category =  categoryService.getCategory(id);
		System.out.println(category);
		return category;           
    }
   
//    @Get("/")
//    public Iterable<Category> getCategories() {
//    	Iterable<Category> ret = categoryService.getCategories();
//    	for(Category cat: ret) {
//    		System.out.println(cat.getName());
//    	}
//    	return ret;
//    }
    
    
}