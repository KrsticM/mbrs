package ftn.uns.ac.rs.controller;

import javax.inject.Inject;

import ftn.uns.ac.rs.dto.ProductDTO;
import ftn.uns.ac.rs.mapper.ProductMapper;
import ftn.uns.ac.rs.model.Product;
import ftn.uns.ac.rs.service.ProductService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;

/*
 * Svuda se mapira na full DTO objekat.
 */

@Controller("/product")
public class ProductController {
	@Inject
	private ProductService productService;

	@Get
	public Page<ProductDTO> getAll(Pageable pageable) {
		return productService.findAll(pageable).map(ProductMapper::fullProductDTO);
	}

	@Get("/{id}")
	public ProductDTO getOne(Integer id){
		return ProductMapper.fullProductDTO(productService.findOne(id));
	}

	@Post
	public ProductDTO save(@Body Product product) {
		return ProductMapper.fullProductDTO(productService.save(product));
	}

	@Put("/{id}")
	public ProductDTO edit(Integer id, @Body Product product){
		return ProductMapper.fullProductDTO(productService.update(id, product));
	}

	@Delete("/{id}")
	public void delete(Integer id){
		productService.delete(id);
	}

}
