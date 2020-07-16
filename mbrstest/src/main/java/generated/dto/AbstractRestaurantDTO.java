package generated.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractRestaurantDTO {
	/*
	 * Ove idu isključivi pola koja imaju getter-e.
	 * Sve što nije porst tip, menja se njegovim DTO objektom.
	 */
	protected Integer id;	
	protected String name;	
	protected AbstractCategoryDTO category;
	protected Set<AbstractProductDTO> products = new HashSet<AbstractProductDTO>();
}
