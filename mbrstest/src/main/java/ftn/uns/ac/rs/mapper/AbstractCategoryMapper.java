package ftn.uns.ac.rs.mapper;

import ftn.uns.ac.rs.dto.AbstractCategoryDTO;
import ftn.uns.ac.rs.model.Category;
import hand.dto.CategoryDTO;

public abstract class AbstractCategoryMapper{
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public static AbstractCategoryDTO fullConversion(Category entity) {
		AbstractCategoryDTO ret = simpleConversion(entity);
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public static AbstractCategoryDTO simpleConversion(Category entity) {
		AbstractCategoryDTO ret = new CategoryDTO();
		ret.setId(entity.getId());
		ret.setName(entity.getName());
		return ret;
	}
}
