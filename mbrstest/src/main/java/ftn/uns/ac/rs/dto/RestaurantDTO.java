package ftn.uns.ac.rs.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDTO {
	private Integer id;	
	private String name;	
	private CategoryDTO category;
	private Set<ProductDTO> products = new HashSet<ProductDTO>();
}
