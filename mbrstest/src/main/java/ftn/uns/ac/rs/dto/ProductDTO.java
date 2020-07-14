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
	private Integer id;	
	private String name;
	private ProductType type;
	private RestaurantDTO restaurant;	
}
