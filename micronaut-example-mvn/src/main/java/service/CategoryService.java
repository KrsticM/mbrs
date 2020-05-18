package service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.runtime.ApplicationConfiguration;
import io.micronaut.spring.tx.annotation.Transactional;
import model.Category;
import repository.CategoryRepository;


@Singleton
public class CategoryService {

	@Inject
	private CategoryRepository categoryRepository;
	
	 @PersistenceContext
	 private EntityManager entityManager;
	 private final ApplicationConfiguration applicationConfiguration;

    public CategoryService(@CurrentSession EntityManager entityManager,
                               ApplicationConfiguration applicationConfiguration){
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

	@Transactional(readOnly = true)
	public Category getCategory(Long id) {
    	System.out.println("usao u service");
		Optional<Category> opt = Optional.ofNullable(entityManager.find(Category.class, id));
		if(!opt.isPresent()) {
			System.out.println("aaa");
			return null;
		}
		System.out.println(opt.get());
		return opt.get();
	}
	
//	@Transactional(readOnly = true)
//	public Iterable<Category> getCategories() {
//		Iterable<Category> categories = categoryRepository.findAll();
//		return categories;
//	}
	

}
