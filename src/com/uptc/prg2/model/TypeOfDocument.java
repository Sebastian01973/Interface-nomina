package com.uptc.prg2.model;

/**
 * @description Este clase nos da los tipos de documentacion
 * @author Sebastian Felipe Martinez Samaca
 * @date 06/06/2020
 */
public enum TypeOfDocument {

	IDENTIFICATION_PERSONAL("Identification_Personal"), // cedula de ciudadania
	IDENTIFICATION_FOREIGHER("Identification_Foreigher"), // cedula extranjera
	PASSPORT("Passport"); // pasaporte
	
	private final String text; // el texto
	
	private TypeOfDocument(String text) {
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
