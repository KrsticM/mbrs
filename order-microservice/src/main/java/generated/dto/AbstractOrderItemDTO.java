package generated.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractOrderItemDTO {
	/*
	 * Ove idu isključivi pola koja imaju getter-e.
	 * Sve što nije porst tip, menja se njegovim DTO objektom.
	 */
	protected Integer id;
	protected Integer quantity;
	protected AbstractOrderDTO order;
	/*
	 * Polja koja pripadaju drugim mikroservisima menjamo sa DTO.
	 */
	protected AbstractFeignProductDTO product;
}
