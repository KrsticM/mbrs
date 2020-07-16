package generated.mapper;

import generated.dto.AbstractCategoryDTO;
import generated.model.Category;
import hand.dto.CategoryDTO;

public abstract class AbstractCategoryMapper implements Mapper<Category, AbstractCategoryDTO>{
	protected AbstractMapperCatalogue mapperCatalogue;
	
	public AbstractCategoryMapper(AbstractMapperCatalogue mapperCatalogue) {
		this.mapperCatalogue = mapperCatalogue;
	}
	
	/*
	 * Ovde se setuju sva polja koja su složeni tip.
	 * Svi oni se setuju na basic DTO verziju (dakle bez drugih složenih tipova),
	 * jer jedino tako znamo da sigurno nema kružnih referenci.
	 */
	public AbstractCategoryDTO fullConversion(Category entity) {
		AbstractCategoryDTO ret = simpleConversion(entity);
		return ret;
	}
	
	/*
	 * Ove se setuju ključ. (Ako je ključ objekat, a ne jednostavan tip i dalje se setuje).
	 * Zatim se setuju sva polja koja su prosti tip.
	 */
	public AbstractCategoryDTO simpleConversion(Category entity) {
		AbstractCategoryDTO ret = new CategoryDTO();
		ret.setId(entity.getId());
		ret.setName(entity.getName());
		return ret;
	}
}
