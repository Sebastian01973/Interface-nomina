package com.uptc.prg2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class Subsidy {

	private ArrayList<Register> registers;

	public Subsidy() {
		registers = new ArrayList<Register>();
		addClient();
		generateCode();
	}

	/**
	 * @param name
	 * @param person
	 * @param docu
	 * @param solicitude
	 * @param nit
	 * @param employees
	 * @param date
	 * @return
	 */
	public Register createRegister(String name,TypeOfPerson person,TypeOfDocument docu,TypeOfSolicitude solicitude,String nit,int employees,LocalDate date) {
		return new Register(new Business(name,person , docu, solicitude, nit, employees), date);
	}
	
	public void addRegister(Register register) {
		registers.add(register);
	}
	
	public double getBonus() {
		double aux = 0;
		for (Register register : registers) {
			aux += register.getBusiness().calculateSalaryForEmployees(980657);
		}
		return aux;
	}

	/**
	 * @return
	 */
	public String[] getCodes() {
		int size = registers.size();
		String[] auxCodeStrings = new String[size];
		for (int i = 0; i < size; i++) {
			auxCodeStrings[i] = registers.get(i).getCodeAuto();
		}
		return auxCodeStrings;
	}
	
	
	/**
	 * @descrption Este metodo nos genera un codigo segun el registro
	 */
	public void generateCode() {
		int size = registers.size();
		int codeAuto = 0;
		for (int i = 0; i < size; i++) {
			codeAuto ++;
			registers.get(i).generateNumber(String.valueOf(codeAuto));
		}
	}
	
	/**
	 * @description Este metodo busca un registro
	 * @param numberAuto el codigo con el que se busca
	 * @return retorna el registro del subsidio
	 */
	public Register searchRegister(String numberAuto) {
		for (Register register : registers) {
			if (register.isvalidateNumber(numberAuto)) {
				return register;
			}
		}
		return null;
	}
	
	public boolean isValidateCode(String code) {
		for (Register register : registers) {
			if (register.isvalidateNumber(code)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @descrption Este metodo nos da la lista de los que se aceptan segun la fecha
	 * @param months
	 * @return
	 */
	public ArrayList<Register> getRegisterOnDate(int...months){
		ArrayList<Register> newRegister = new ArrayList<Register>();
		for (Register register : registers) {
			if (register.getDateOfRegister().getMonthValue() == months[0] || register.getDateOfRegister().getMonthValue() == months[1]
				|| register.getDateOfRegister().getMonthValue() == months[2]) {
				newRegister.add(register);
			}
		}
		return newRegister;
	}
	

	/**
	 * @description Este metodo elimina un registro 
	 * @param numberAuto el codigo con el que se busca
	 */
	public void deleteRegister(String numberAuto) {
		int size = registers.size();
		for (int i = 0; i < size-1; i++) {
			if (registers.get(i).isvalidateNumber(numberAuto)) {
				this.registers.remove(i);
			}
		}
	}
	
	/**
	 * @descrption Este metodo me calcula el porcentaje de personas registradas
	 * en el registro del subsidio
	 * @return el porcentaje de las soliciutdes
	 */
	public float getPercetageTypeSolicitude(TypeOfSolicitude solicitude) {
		int values = 0;
		for (Register register : registers) {
			if (register.getBusiness().solicitude.equals(solicitude)) {
				values++;
			}
		}
		return ((float)values*100/registers.size());
	}
	
	public Object[] getPercentagesOfTypeSoliAll() {
		Object[] auxFloat = new Object[TypeOfSolicitude.values().length];
		for (int i = 0; i < auxFloat.length; i++) {
			TypeOfSolicitude auxTypeSoli = TypeOfSolicitude.values()[i];
			auxFloat[i] = getPercetageTypeSolicitude(auxTypeSoli);
		}
		return auxFloat;
	}
	
	/**
	 * @description Este metodo nos busca el porcentaje de el tipo de persona
	 * @param person
	 * @return los porcentajes de persona
	 */
	public float getPercentageTypeOfPer(TypeOfPerson person) {
		int values = 0;
		for (Register register : registers) {
			if (register.getBusiness().typeOfPerson.equals(person)) {
				values++;
			}
		}
		return ((float)values*100/registers.size());
	}
	
	public Object[] getPercentagesOfTypePerAll() {
		Object[] auxFloat = new Object[TypeOfPerson.values().length];
		for (int i = 0; i < auxFloat.length; i++) {
			TypeOfPerson auxTypePer = TypeOfPerson.values()[i];
			auxFloat[i] = getPercentageTypeOfPer(auxTypePer);
		}
		return auxFloat;
	}
	
	/**
	 * @descrption Este metodo nos busca el porcenatje por documento
	 * @param docu
	 * @return
	 */
	public float getPercentageTypeOfDocu(TypeOfDocument docu) {
		int values = 0;
		for (Register register : registers) {
			if (register.getBusiness().typeOfDocument.equals(docu)) {
				values++;
			}
		}
		return ((float)values*100/registers.size());
	}
	
	public Object[] getPercentagesOfTypeDocuAll() {
		Object[] auxFloat = new Object[TypeOfDocument.values().length];
		for (int i = 0; i < auxFloat.length; i++) {
			TypeOfDocument auxTypeDocu = TypeOfDocument.values()[i];
			auxFloat[i] = getPercentageTypeOfDocu(auxTypeDocu);
		}
		return auxFloat;
	}
	
	/**
	 * @description este metodo nos da el porcentaje segun el mes
	 * @param register
	 * @param month
	 * @return
	 */
	public float getPercentageOnDate(ArrayList<Register> register,int month) {
		int values = 0;
		for (Register reg : register) {
			if (reg.getDateOfRegister().getMonthValue() == month) {
				values++;
			}
		}
		return ((float)values*100/register.size());
	}
	
	public Object[] getPercentageOnDateAll() {
		int[] months = {4,5,6};
		Object[] objects = new Object[months.length];
		for (int i = 0; i < objects.length; i++) {
			objects[i] = getPercentageOnDate(registers,months[i]);
		}
		return objects;
	}

	/**@descrption Este metodo nos busca un registro
	 * @param index
	 * @return
	 */
	public Register getRegister(int index) {
		return registers.get(index);
	}
	
	public ArrayList<Register> getRegisters(){
		return registers;
	}
	
	public String getCode(Register register) {
		return register.getCodeAuto();
	}
	

	public ArrayList<Object[]> getMatrixData() {
		ArrayList<Object[]> auxDatasArrayList = new ArrayList<>();
		for (Register register : registers) {
			auxDatasArrayList.add(register.toVectorObject());
		}
		return auxDatasArrayList;
	}
	
	/**
	 * @description Este metodo nos da el tamaño del array
	 * @return
	 */
	public int getSize() {
		return registers.size();
	}
	
	/**
	 * @descrption Este metodo nos agrega las cuentas quemadas para hacer las pruebas
	 */
	public void addClient() {
		registers.add(new Register(new Business("CocoMania", TypeOfPerson.NATURAL_PERSONAL, TypeOfDocument.IDENTIFICATION_FOREIGHER, TypeOfSolicitude.SECOND_TIME,"35456321", 5), LocalDate.of(2020, 5, 19)));
		registers.add(new Register(new Business("Unicentro", TypeOfPerson.LEGAL_PERSON, TypeOfDocument.PASSPORT, TypeOfSolicitude.THIRD_TIME,"123446541", 3), LocalDate.of(2020, 6, 29)));
		registers.add(new Register(new Business("Rositas", TypeOfPerson.NONPROFIT_ENTITY, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.FIRST_TIME,"1223456", 3), LocalDate.of(2019, 8, 23)));
		registers.add(new Register(new Business("Unicef", TypeOfPerson.TEMPORARY_UNION, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.SECOND_TIME,"245645653", 10), LocalDate.of(2020, 6, 21)));
		registers.add(new Register(new Business("Icbf", TypeOfPerson.NATURAL_PERSONAL, TypeOfDocument.IDENTIFICATION_FOREIGHER, TypeOfSolicitude.THIRD_TIME,"23567875", 5), LocalDate.of(2020, 4, 23)));
		registers.add(new Register(new Business("comodisimos", TypeOfPerson.NONPROFIT_ENTITY, TypeOfDocument.PASSPORT, TypeOfSolicitude.SECOND_TIME,"70549221", 8), LocalDate.of(2020, 5, 9)));
		registers.add(new Register(new Business("brazzers", TypeOfPerson.TEMPORARY_UNION, TypeOfDocument.PASSPORT, TypeOfSolicitude.FIRST_TIME,"40819788", 9), LocalDate.of(2020, 3, 19)));
		registers.add(new Register(new Business("ktronix", TypeOfPerson.LEGAL_PERSON, TypeOfDocument.IDENTIFICATION_FOREIGHER, TypeOfSolicitude.FIRST_TIME,"100244356", 3), LocalDate.of(2019, 12, 29)));
		registers.add(new Register(new Business("smarfit", TypeOfPerson.NATURAL_PERSONAL, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.THIRD_TIME,"104963234", 11), LocalDate.of(2020, 4, 10)));
		registers.add(new Register(new Business("Claro", TypeOfPerson.NONPROFIT_ENTITY, TypeOfDocument.PASSPORT, TypeOfSolicitude.SECOND_TIME,"100277321", 3), LocalDate.of(2020, 6, 23)));
		registers.add(new Register(new Business("Tigo", TypeOfPerson.NATURAL_PERSONAL, TypeOfDocument.PASSPORT, TypeOfSolicitude.FIRST_TIME,"13676542", 5), LocalDate.of(2020, 2, 13)));
		registers.add(new Register(new Business("Etb", TypeOfPerson.TEMPORARY_UNION, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.FIRST_TIME,"68432453", 8), LocalDate.of(2020, 6, 20)));
		registers.add(new Register(new Business("Conchita", TypeOfPerson.LEGAL_PERSON, TypeOfDocument.IDENTIFICATION_FOREIGHER, TypeOfSolicitude.THIRD_TIME,"40018385", 3), LocalDate.of(2020, 5, 3)));
		registers.add(new Register(new Business("champagne", TypeOfPerson.TEMPORARY_UNION, TypeOfDocument.PASSPORT, TypeOfSolicitude.SECOND_TIME,"778641232", 4), LocalDate.of(2020, 4, 6)));
		registers.add(new Register(new Business("el baratillo", TypeOfPerson.LEGAL_PERSON, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.THIRD_TIME,"57678776", 3), LocalDate.of(2020, 5, 23)));
		registers.add(new Register(new Business("boyacoman", TypeOfPerson.LEGAL_PERSON, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.FIRST_TIME,"184358735", 3), LocalDate.of(2020, 3, 6)));
		registers.add(new Register(new Business("batman", TypeOfPerson.NONPROFIT_ENTITY, TypeOfDocument.PASSPORT, TypeOfSolicitude.THIRD_TIME,"325644312", 9), LocalDate.of(2020, 2, 21)));
		registers.add(new Register(new Business("Cosmo-In", TypeOfPerson.NONPROFIT_ENTITY, TypeOfDocument.IDENTIFICATION_FOREIGHER, TypeOfSolicitude.SECOND_TIME,"1244651", 19), LocalDate.of(2020, 3, 2)));
		registers.add(new Register(new Business("McDonals", TypeOfPerson.LEGAL_PERSON, TypeOfDocument.IDENTIFICATION_FOREIGHER, TypeOfSolicitude.FIRST_TIME,"68677504", 14), LocalDate.of(2020, 4, 24)));
		registers.add(new Register(new Business("Lays", TypeOfPerson.NONPROFIT_ENTITY, TypeOfDocument.IDENTIFICATION_PERSONAL, TypeOfSolicitude.SECOND_TIME,"95867032", 3), LocalDate.of(2020, 4, 23)));
	}
}
