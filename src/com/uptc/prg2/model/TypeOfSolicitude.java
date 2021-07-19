package com.uptc.prg2.model;

/**
 * @descrption Este clase son los intentos de solicitudes
 * @author Sebastian Felipe Martinez Samaca
 * @date 06/06/2020
 */
public enum TypeOfSolicitude {

	FIRST_TIME("First_Time"), // primera vez
	SECOND_TIME("Second_Time"), // segunda voz
	THIRD_TIME("Third_Time"); // tercera voz
	
	private final String text; // el texto
	
	private TypeOfSolicitude(String text) {
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
