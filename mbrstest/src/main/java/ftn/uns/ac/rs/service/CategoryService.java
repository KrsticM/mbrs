package ftn.uns.ac.rs.service;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import ftn.uns.ac.rs.model.Category;
import ftn.uns.ac.rs.repository.CategoryRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class CategoryService{
	@Inject
	protected CategoryRepository repo;
	
	public Page<Category> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
		
	public Category findOne(Integer id){
		Optional<Category> optionalUser = repo.findById(id);
		if (optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	public Category save(Category entity) {
		return repo.update(entity);
	}
	
	public Category update(Integer id, Category newEntity) throws IllegalAccessException, InvocationTargetException{
		Category entity = findOne(id);
		newEntity.setId(entity.getId());
		return save(newEntity);
	}
		
	public void delete(Integer id){
		Category entity = findOne(id);
		repo.delete(entity);
	}
}
