package ftn.uns.ac.rs.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import ftn.uns.ac.rs.model.Product;
import hand.repository.ProductRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

/*
 * Singleton anotacija mora iznad konkretnih, inače ne radi inject.
 */
public abstract class AbstractProductService {
	/*
	 * Konkretni repo, da bi korisnik video svoje dodatne metode bez castovanja.
	 */
	@Inject
	protected ProductRepository repo;
	
	public Page<Product> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	/*
	 * Ova exception ne mora da ima throw, ali svakako ce ga obraditi handler.
	 * Isti se baci i ako, na primer, restoranu postavimo kategoriju koja ne postoji.
	 */
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
	
	/*
	 * Ovde se setuju sva polja koja imaju setter i koja nisu id ili liste.
	 */
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
