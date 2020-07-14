package ftn.uns.ac.rs.model;

public enum ProductType {
	MEAL,
	DRINK;
	
	public String get() {
		switch (this) {
			case MEAL:
				return "MEAL";
			case DRINK:
				return "DRINK";
			default:
				return "";
		}
	}
}
