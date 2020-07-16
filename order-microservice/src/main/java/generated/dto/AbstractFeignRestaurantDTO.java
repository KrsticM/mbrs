package generated.dto;

import lombok.Getter;
import lombok.Setter;

/*
 * DTO klasa generisana zbog klase iz drugog mikroservisa, koju
 * ovaj koristi.
 * Sadži samo polja koja su osnovni tip.
 */

@Getter
@Setter
public abstract class AbstractFeignRestaurantDTO {
	protected Integer id;
	protected String name;
}
