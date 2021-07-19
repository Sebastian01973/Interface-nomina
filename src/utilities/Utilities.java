package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import com.uptc.prg2.model.TypeOfDocument;
import com.uptc.prg2.model.TypeOfPerson;
import com.uptc.prg2.model.TypeOfSolicitude;

import controllers.Controller;
import persistence.HandlerLanguage;

public class Utilities {
	
	public static String[] splitLine(String line) {
		return line.split("#");
	}
	
	public static LocalDate getDates(String data) {
		String[] auxDatas = data.split("/");
		return (LocalDate.of(Integer.parseInt(auxDatas[2]),Integer.parseInt(auxDatas[1]),Integer.parseInt(auxDatas[0])));
	}
	
	public static String dateToString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("dd/M/yyyy"));
	}
	
	public static ArrayList<String> getDataForWrite(ArrayList<Object[]> datas){
		ArrayList<String> auxDatas = new ArrayList<>();
		int size = datas.size();
		for (int i = 0; i < size; i++) {
			auxDatas.add((String)datas.get(i)[1]+"#"+(String)datas.get(i)[2]+"#"+(String)datas.get(i)[3]+
					"#"+(String)datas.get(i)[4]+"#"+(String)datas.get(i)[5]+"#"+String.valueOf(datas.get(i)[6])
					+"#"+dateToString((LocalDate)datas.get(i)[7]));
		}
		return auxDatas;
	}
	
	public static TypeOfPerson geTypeOfPerson(String data) {
		switch (data) {
		case "TemporatyUnion": return TypeOfPerson.TEMPORARY_UNION;
		case "NaturalPerson": return TypeOfPerson.NATURAL_PERSONAL;
		case "LegalPerson": return TypeOfPerson.LEGAL_PERSON;
		case "NonprofitEntity": return TypeOfPerson.NONPROFIT_ENTITY;
		default: return null;
		}
	}
	
	public static TypeOfDocument geTypeOfDocument(String data) {
		switch (data) {
		case "IDForeigher": return TypeOfDocument.IDENTIFICATION_FOREIGHER;
		case "IDPersonal": return TypeOfDocument.IDENTIFICATION_PERSONAL;
		case "Passport": return TypeOfDocument.PASSPORT;
		default: return null;
		}
	}
	
	public static TypeOfSolicitude geTypeOfSolicitude(String data) {
		switch (data) {
		case "FirsTime": return TypeOfSolicitude.FIRST_TIME;
		case "SecondTime": return TypeOfSolicitude.SECOND_TIME;
		case "ThirdTime": return TypeOfSolicitude.THIRD_TIME;
		default: return null;
		}
	}
	
	public static TypeOfPerson getTypeOfPerson(int index) {
		switch (index) {
		case 0: return TypeOfPerson.LEGAL_PERSON;
		case 1: return TypeOfPerson.NATURAL_PERSONAL;
		case 2: return TypeOfPerson.NONPROFIT_ENTITY;
		case 3: return TypeOfPerson.TEMPORARY_UNION;
		default:
			return null;
		}
	}
	
	public static TypeOfDocument getTypeOfDocument(int index) {
		switch (index) {
		case 1: return TypeOfDocument.IDENTIFICATION_FOREIGHER;
		case 0: return TypeOfDocument.IDENTIFICATION_PERSONAL;
		case 2: return TypeOfDocument.PASSPORT;
		default:
			return null;
		}
	}
	
	public static TypeOfSolicitude getTypeOfSolicitude(int index) {
		switch (index) {
		case 0: return TypeOfSolicitude.FIRST_TIME;
		case 1: return TypeOfSolicitude.SECOND_TIME;
		case 2: return TypeOfSolicitude.THIRD_TIME;
		default:
			return null;
		}
	}
	
	public static Object[] getConstants(Object[] constants) {
		String[] auxConstants = new String[constants.length];
		for (int i = 0; i < constants.length; i++) {
			auxConstants[i] = getConstant(String.valueOf(constants[i]));
		}
		return auxConstants;
	}
	
	public static String getConstant(String constant) {
		return HandlerLanguage.languageProperties.getProperty(constant);
	}
	
	public static boolean isValidateDatas(String JTFName,String JTFNit,Date date) {
		if (JTFName.isEmpty() || JTFNit.isEmpty() || date == null) {
			return true;
		}else {
			return false;
		}
	}

	public static Properties generateProperties( String pathFile ) throws IOException {
		Properties properties = new Properties();
		InputStream input = new FileInputStream(pathFile);
		properties.load( input );
		return properties;
	}
	
	public static void saveProperties( Properties properties, String pathFile ) throws IOException{
		FileOutputStream output = new FileOutputStream(pathFile);
		properties.store(output, null);
		output.close();
	}
}
