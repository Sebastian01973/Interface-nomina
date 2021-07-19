package utilities;

import java.time.LocalDate;
import java.time.Month;
import java.util.GregorianCalendar;

import com.uptc.prg2.model.TypeOfDocument;
import com.uptc.prg2.model.TypeOfPerson;
import com.uptc.prg2.model.TypeOfSolicitude;

public class SelfGenerated {
	
	public static TypeOfSolicitude generateTypeSolicitude() {
		int number = randBetween(0, 2);
		for (TypeOfSolicitude solicitude : TypeOfSolicitude.values()) {
			if (solicitude.ordinal() == number) {
				return solicitude;
			}
		}
		return null;
	}
	
	public static TypeOfDocument generateTypeDocument() {
		int number = randBetween(0, 2);
		for (TypeOfDocument documen : TypeOfDocument.values()) {
			if (documen.ordinal() == number) {
				return documen;
			}
		}
		return null;
	}
	
	public static TypeOfPerson generateTypePerson() {
		int number = randBetween(0, 3);
		for (TypeOfPerson person : TypeOfPerson.values()) {
			if (person.ordinal() == number) {
				return person;
			}
		}
		return null;
	}
	
	public static String generateNit() {
		int value = randBetween(1234567,9999999);
		return String.valueOf(value);
	}
	
	public static LocalDate toConverterCalendar() {
		int year = randBetween(2015, 2025);
		int month = randBetween(1, 12);
		int day = randBetween(1, 30);
		if (year == 2019 && month == 2) {
			
		}
		return LocalDate.of(year,month,day);
	}
	
	public static boolean isLeapYear(int year) {
		if(year%4 == 0) {
			return true;
		}
		return false;
	}

	public static GregorianCalendar generateCalendar() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(gc.YEAR,randBetween(2015, 2025));
		gc.set(gc.DAY_OF_YEAR,randBetween(1,gc.getActualMaximum(gc.DAY_OF_YEAR)));
		return gc;
	}
	/**
	 * @description Este metodo nos genera un numero al azar entre star y end
	 * @param start donde comienza el numero
	 * @param end donde termina
	 * @return el numero al azar
	 */
	public static int randBetween(int start,int end) {
		return start + (int)Math.round(Math.random()*(end-start));
	}	
}
