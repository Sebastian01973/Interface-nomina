package com.uptc.prg2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/**
 * @description Esta clase nos registra las empresas que quierer participar del subsidio
 * @author Sebastian Felipe Martinez Samaca
 * @date 06/06/2020
 */
public class Register{

	private Business business; // los datos de la empresa
	private LocalDate dateOfRegister; // la fecha que se registran
	private String codeAuto; // El numero radicado
	
	/**
	 * @descrption Este es el contructor
	 * @param business
	 * @param dateOfRegister
	 */
	public Register(Business business,LocalDate dateOfRegister) {
		this.business = business;
		this.dateOfRegister = dateOfRegister;
		codeAuto = "";
	}
	
	/**
	 * @description Este metodo nos devuelve el codigo generado
	 * @return nos devuelve el codigo
	 */
	public String getCodeAuto() {
		return codeAuto;
	}
	
	/**
	 * @descrption Este metodo nos agrega el codigo
	 * @param codeAuto
	 */
	public void generateNumber(String codeAuto) {
		this.codeAuto = codeAuto;
	}
	
	/**
	 * @descrption Este nos valida si el codigo es valido 
	 * @param codeAuto
	 * @return true si cumple false si no 
	 */
	public boolean isvalidateNumber(String codeAuto) {
		return this.codeAuto.equals(codeAuto);
	}

	public Business getBusiness() {
		return business;
	}

	public LocalDate getDateOfRegister() {
		return dateOfRegister;
	}
	
	public Object[] toVectorObject() {
		return new Object[] {codeAuto,business.NameBusiness,business.typeOfPerson.getText(),business.typeOfDocument.getText(),business.solicitude.getText(),
				business.nit,business.numberEmployees,dateOfRegister,business.calculateSalaryForEmployees(985676)};
	}
	
	public String name() {
		String string = getBusiness().NameBusiness + "-" + getBusiness().typeOfPerson.getText() +"-" +
				getBusiness().typeOfDocument.getText() + "-" +getBusiness().solicitude.getText() + "-" +
				getBusiness().nit +"-" + getBusiness().numberEmployees +"-" +dateOfRegister.getYear() + "-" + dateOfRegister.getMonthValue() + "-" + dateOfRegister.getDayOfMonth();
		return string;
	}
	
}
