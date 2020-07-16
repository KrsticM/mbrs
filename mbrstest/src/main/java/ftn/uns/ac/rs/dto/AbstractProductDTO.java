package ftn.uns.ac.rs.dto;

import ftn.uns.ac.rs.model.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractProductDTO {
	/*
	 * Ove idu isključivi pola koja imaju getter-e.
	 * Sve što nije porst tip, menja se njegovim DTO objektom.
	 */
	protected Integer id;	
	protected String name;
	protected ProductType type;
	protected AbstractRestaurantDTO restaurant;	
}
