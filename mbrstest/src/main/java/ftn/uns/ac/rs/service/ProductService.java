package ftn.uns.ac.rs.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityNotFoundException;

import ftn.uns.ac.rs.model.Product;
import ftn.uns.ac.rs.repository.ProductRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

@Singleton
public class ProductService {
	@Inject
	protected ProductRepository repo;
	
	public Page<Product> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
		
	public Product findOne(Integer id){
		Optional<Product> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("No row with the given identifier exists: [" + Product.class.getName() + ":" + id +"]");
	}
	
	public Product save(Product entity) {
		return repo.update(entity);
	}
	
	public Product update(Integer id, Product newEntity){
		Product entity = findOne(id);
		entity.setName(newEntity.getName());
		entity.setType(newEntity.getType());
		entity.setRestaurant(newEntity.getRestaurant());
		return save(entity);
	}
		
	public void delete(Integer id){
		Product entity = findOne(id);
		repo.delete(entity);
	}
}
