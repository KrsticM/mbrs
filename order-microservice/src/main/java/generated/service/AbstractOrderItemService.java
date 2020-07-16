package generated.service;

import java.util.Locale.Category;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import generated.model.OrderItem;
import handwritten.repository.OrderItemRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

public class AbstractOrderItemService {
	/*
	 * Konkretni repo, da bi korisnik video svoje dodatne metode bez castovanja.
	 */
	@Inject
	protected OrderItemRepository repo;
	
	public Page<OrderItem> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	/*
	 * Ova exception ne mora da ima throw, ali svakako ce ga obraditi handler.
	 * Isti se baci i ako, na primer, restoranu postavimo kategoriju koja ne postoji.
	 */
	public OrderItem findOne(Integer id){
		Optional<OrderItem> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("No row with the given identifier exists: [" + Category.class.getName() + ":" + id +"]");
	}
	
	public OrderItem save(OrderItem entity) {
		return repo.update(entity);
	}
	
	/*
	 * Ovde se setuju sva polja koja imaju setter i koja nisu id ili liste.
	 */
	public OrderItem update(Integer id, OrderItem newEntity){
		OrderItem entity = findOne(id);
		entity.setQuantity(newEntity.getQuantity());
		entity.setOrder(newEntity.getOrder());
		entity.setProduct(newEntity.getProduct());
		return save(entity);
	}
		
	public void delete(Integer id){
		OrderItem entity = findOne(id);
		repo.delete(entity);
	}
}
