package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.model.Product;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.PageableRepository;

@Repository
public interface ProductRepository extends PageableRepository<Product, Integer> {

}
