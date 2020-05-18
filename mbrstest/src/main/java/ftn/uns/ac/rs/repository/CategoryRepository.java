package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.model.Category;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface CategoryRepository extends PageableRepository<Category, Integer>{

}
