package generated.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import generated.dto.AbstractFeignRestaurantDTO;
import generated.model.Order;
import handwritten.feignclient.RestaurantFeignClient;
import handwritten.repository.OrderRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

/*
 * Singleton anotacija mora iznad konkretnih, inače ne radi inject.
 */
public abstract class AbstractOrderService {
	/*
	 * Konkretni repo, da bi korisnik video svoje dodatne metode bez castovanja.
	 */
	@Inject
	protected OrderRepository repo;
	
	@Inject
	protected RestaurantFeignClient restaurantFeignClient;
	
	public Page<Order> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	/*
	 * Ova exception ne mora da ima throw, ali svakako ce ga obraditi handler.
	 * Isti se baci i ako, na primer, restoranu postavimo kategoriju koja ne postoji.
	 */
	public Order findOne(Integer id){
		Optional<Order> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("No row with the given identifier exists: [" + Order.class.getName() + ":" + id +"]");
	}
	
	public Order save(Order entity) {
		//Ovde idu provere za feign atribute.
		AbstractFeignRestaurantDTO restaurant = restaurantFeignClient.getOne(entity.getRestaurant());
		if(restaurant == null) {
			throw new EntityNotFoundException("No row with the given identifier exists: [ Restaurant:" + entity.getRestaurant() +"]"); 
		}
		return repo.update(entity);
	}
	
	/*
	 * Ovde se setuju sva polja koja imaju setter i koja nisu id ili liste.
	 */
	public Order update(Integer id, Order newEntity){
		Order entity = findOne(id);
		entity.setDateOrdered(newEntity.getDateOrdered());		
		entity.setRestaurant(newEntity.getRestaurant());
		return save(entity);
	}
		
	public void delete(Integer id){
		Order entity = findOne(id);
		repo.delete(entity);
	}
}
