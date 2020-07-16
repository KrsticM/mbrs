package generated.dto;

import generated.model.ProductType;
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
