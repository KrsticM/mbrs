package generated.service;

import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import generated.model.Restaurant;
import hand.repository.RestaurantRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

/*
 * Singleton anotacija mora iznad konkretnih, inače ne radi inject.
 */
public abstract class AbstractRestaurantService {
	/*
	 * Konkretni repo, da bi korisnik video svoje dodatne metode bez castovanja.
	 */
	@Inject
	protected RestaurantRepository repo;

	public Page<Restaurant> findAll(Pageable pageable) {
		return repo.findAll(pageable);
	}

	/*
	 * Ova exception ne mora da ima throw, ali svakako ce ga obraditi handler.
	 * Isti se baci i ako, na primer, restoranu postavimo kategoriju koja ne postoji.
	 */
	public Restaurant findOne(Integer id){
		Optional<Restaurant> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new EntityNotFoundException("No row with the given identifier exists: [" + Restaurant.class.getName() + ":" + id +"]");
	}

	public Restaurant save(Restaurant entity) {
		return repo.update(entity);
	}
	
	/*
	 * Ovde se setuju sva polja koja imaju setter i koja nisu id ili liste.
	 */
	public Restaurant update(Integer id, Restaurant newEntity){
		Restaurant entity = findOne(id);
		entity.setName(newEntity.getName());
		entity.setCategory(newEntity.getCategory());
		return save(entity);
	}
	
	public void delete(Integer id){
		Restaurant entity = findOne(id);
		repo.delete(entity);
	}
}
