package ftn.uns.ac.rs.mapper;

import ftn.uns.ac.rs.dto.CategoryDTO;
import ftn.uns.ac.rs.model.Category;

public class CategoryMapper {
	public static CategoryDTO fullCategoryDTO(Category category) {
		CategoryDTO ret = simpleCategoryDTO(category);
		return ret;
	}

	public static CategoryDTO simpleCategoryDTO(Category category) {
		CategoryDTO ret = new CategoryDTO();
		ret.setId(category.getId());
		ret.setName(category.getName());
		return ret;
	}
}
