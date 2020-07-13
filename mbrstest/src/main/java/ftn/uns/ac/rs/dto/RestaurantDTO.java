package ftn.uns.ac.rs.dto;

import ftn.uns.ac.rs.model.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RestaurantDTO {
	private Integer id;	
	private String name;	
	private Integer categoryId;	
	
	public RestaurantDTO(Restaurant restaurant) {
		this.id = restaurant.getId();
		this.name = restaurant.getName();
		this.categoryId = restaurant.getCategory().getId();
	}

}
