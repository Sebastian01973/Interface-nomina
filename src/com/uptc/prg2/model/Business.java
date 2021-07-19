package com.uptc.prg2.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description Este clase nos pide los datos que se requieren de la empresa
 * @author Sebastian Felipe Martinez Samaca
 * @date 06/06/2020
 */
public class Business {

	protected String NameBusiness; // el nombre de la empresa
	protected TypeOfPerson typeOfPerson; // el tipo de persona
	protected TypeOfDocument typeOfDocument; // el tipo de documento
	protected TypeOfSolicitude solicitude;
	protected String nit; // el numero de documento o nit
	protected int numberEmployees; // numero de empelados
	
	/**
	 * @descrption este metodo es el constructor
	 * @param nameBusiness
	 * @param typeOfPerson
	 * @param typeOfDocument
	 * @param nit
	 * @param numberEmployees
	 */
	public Business(String nameBusiness, TypeOfPerson typeOfPerson, TypeOfDocument typeOfDocument,TypeOfSolicitude solicitude, String nit, int numberEmployees) {
		NameBusiness = nameBusiness;
		this.typeOfPerson = typeOfPerson;
		this.typeOfDocument = typeOfDocument;
		this.solicitude = solicitude;
		this.nit = nit;
		this.numberEmployees = numberEmployees;
	}
	
	
	
	/**
	 * @descrption Este metodo nos dice si es valido el numero de empleados.
	 * @return true si se cumple false si no se cumple
	 */
	public boolean isvalidateNumberEmployee() {
		if (numberEmployees < ConstantModel.NUMBER_MINMIUM_OF_EMPLOYEE) {
			return false;
		}
		return true;
	}
	
	/**
	 * @param salaryMinium // el salario minimo actual
	 * @param percentageCorresponding // el porcentaje que se le quiere dar a cada empleado.
	 * @return el total del saldo
	 */
	public double calculateSalaryForEmployees(double salaryMinium) {
		return salaryMinium*(0.40)*numberEmployees;
	}
	
	/**
	 * @description Este metodo nos dice si esta un enum o no
	 * @param <T>
	 * @param data
	 * @return
	 */
	public <T>boolean isSearchEnum(T data){
		Enum[] enums = {typeOfDocument,typeOfPerson,solicitude};
		for (int i = 0; i < enums.length; i++) {
			if (enums[i].equals(data)) {
				return true;
			}
		}
		return false;
	}
		
}
