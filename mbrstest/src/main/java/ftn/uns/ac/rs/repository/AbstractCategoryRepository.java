package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.model.Category;
import io.micronaut.data.repository.PageableRepository;

/*
 * Anotacija mora iznad konkretnog interfejsa, inače ne radi inject.
 */
public abstract interface AbstractCategoryRepository extends PageableRepository<Category, Integer>{

}
