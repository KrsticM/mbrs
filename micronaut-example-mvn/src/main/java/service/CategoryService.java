package service;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;

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
			ApplicationConfiguration applicationConfiguration) {
		this.entityManager = entityManager;
		this.applicationConfiguration = applicationConfiguration;
	}

	@Transactional(readOnly = true)
	public Category getCategory(Long id) {
		Optional<Category> opt = Optional.ofNullable(entityManager.find(Category.class, id));
		if (!opt.isPresent()) {
			System.out.println("aaa");
			return null;
		}
		return opt.get();
	}
	
	@Transactional(readOnly = true)
	public Iterable<Category> getCategories() {
		String qlString = "SELECT c FROM Category as c";
		TypedQuery<Category> query = entityManager.createQuery(qlString, Category.class);
		return query.getResultList();

	}
	
    @Transactional
    public Category update(@NotNull Category category) {
        return entityManager.merge(category);
    }
    
    @Transactional
    public Category editCategory(Long id, Category dto) {
    	Category category = this.getCategory(id);
    	category.setName(dto.getName());
		return save(category);
	}
    
    @Transactional 
    public Category save(Category category) {
        entityManager.persist(category);
        return category;
	}
    
}
