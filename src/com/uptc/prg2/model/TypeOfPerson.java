package com.uptc.prg2.model;

/**
 * @descrption Este metodo nos muestra los tipos de persona
 * @author Sebastian Felipe Martinez Samaca
 * @date 06/06/2020
 */
public enum TypeOfPerson {

	LEGAL_PERSON("Legal_Person"), // Persona juridica
	NATURAL_PERSONAL("Natural_Person"), // Persona natural
	NONPROFIT_ENTITY("Nonprofit_Entity"), // Entidad sin animo de lucro
	TEMPORARY_UNION("temporary_Union"); // union temporal
	
	private final String text; // el texto
	
	private TypeOfPerson(String text) {
		this.text = text;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	@Override
	public String toString() {
		return getText();
	}
	
}
