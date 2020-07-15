package ftn.uns.ac.rs.dto;

import ftn.uns.ac.rs.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
	/*
	 * Ove idu isključivi pola koja imaju getter-e.
	 * Sve što nije porst tip, menja se njegovim DTO objektom.
	 */
	private Integer id;	
	private String name;
	private ProductType type;
	private RestaurantDTO restaurant;	
}
