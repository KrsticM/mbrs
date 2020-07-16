package ftn.uns.ac.rs.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCategoryDTO {
	/*
	 * Ove idu isključivi pola koja imaju getter-e.
	 * Sve što nije porst tip, menja se njegovim DTO objektom.
	 */
	protected Integer id;	
	protected String name;
}
