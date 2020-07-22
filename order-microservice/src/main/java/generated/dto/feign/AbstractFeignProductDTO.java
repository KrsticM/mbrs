package generated.dto.feign;

import lombok.Getter;
import lombok.Setter;

/*
 * DTO klasa generisana zbog klase iz drugog mikroservisa, koju
 * ovaj koristi.
 * Sadži samo polja koja su osnovni tip.
 */

@Getter
@Setter
public abstract class AbstractFeignProductDTO {
	protected Integer id;
	protected String name;
	/*
	 * Enumeracije ili menjati strinogom ili int-om ili da ih ne dodajemo?
	 */
	protected String type;
}
