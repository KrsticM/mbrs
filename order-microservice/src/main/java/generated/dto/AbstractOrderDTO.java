package generated.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractOrderDTO {
	/*
	 * Ove idu isključivi pola koja imaju getter-e.
	 * Sve što nije porst tip, menja se njegovim DTO objektom.
	 */
	protected Integer id;
	protected Date dateOrdered;
	protected Set<AbstractOrderItemDTO> items = new HashSet<AbstractOrderItemDTO>();
	/*
	 * Polja koja pripadaju drugim mikroservisima menjamo sa DTO.
	 */
	protected AbstractFeignRestaurantDTO restaurant;
}
