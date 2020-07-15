package ftn.uns.ac.rs.mapper;

import ftn.uns.ac.rs.dto.CategoryDTO;
import ftn.uns.ac.rs.model.Category;

public class CategoryMapper {
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public static CategoryDTO fullCategoryDTO(Category category) {
		CategoryDTO ret = simpleCategoryDTO(category);
		return ret;
	}

	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public static CategoryDTO simpleCategoryDTO(Category category) {
		CategoryDTO ret = new CategoryDTO();
		ret.setId(category.getId());
		ret.setName(category.getName());
		return ret;
	}
}
