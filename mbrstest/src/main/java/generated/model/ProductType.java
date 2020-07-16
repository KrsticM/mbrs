package generated.model;

public enum ProductType {
	MEAL,
	DRINK;
	
	/*
	 * Ove je dodano kako bi se u requestu mogla slati vrednost enuma
	 * i kao string, a ne samo kao broj.
	 */
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
