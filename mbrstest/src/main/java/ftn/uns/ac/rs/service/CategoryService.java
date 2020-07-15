package ftn.uns.ac.rs.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityNotFoundException;

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
	
	/*
	 * Ova exception ne mora da ima throw, ali svakako ce ga obraditi handler.
	 * Isti se baci i ako, na primer, restoranu postavimo kategoriju koja ne postoji.
	 */
	public Category findOne(Integer id){
		Optional<Category> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("No row with the given identifier exists: [" + Category.class.getName() + ":" + id +"]");
	}
	
	public Category save(Category entity) {
		return repo.update(entity);
	}
	
	/*
	 * Ovde se setuju sva polja koja imaju setter i koja nisu id ili liste.
	 */
	public Category update(Integer id, Category newEntity){
		Category entity = findOne(id);
		entity.setName(newEntity.getName());
		return save(entity);
	}
		
	public void delete(Integer id){
		Category entity = findOne(id);
		repo.delete(entity);
	}
}
