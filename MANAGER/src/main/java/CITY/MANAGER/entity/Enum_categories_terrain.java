package CITY.MANAGER.entity;

public enum Enum_categories_terrain {
	RTE("Route", null)
	,FOR("Forêt", null)
	;
	
	private String 			description;
	private IF_Influence 	influence;
	
	
	/**
	 * Exemple d'enum avec une description et une interface utilisée pour calculer l'influence d'un type de terrain
	 * @param oDescription
	 * @param oInfluence
	 */
	private Enum_categories_terrain(String oDescription, IF_Influence oInfluence) {
		this.description 	= oDescription;
		this.influence 		= oInfluence;
	}


	public String getDescription() {
		return description;
	}

	public IF_Influence getInfluence() {
		return influence;
	}
}
