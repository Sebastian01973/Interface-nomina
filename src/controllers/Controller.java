package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.uptc.prg2.model.Register;
import com.uptc.prg2.model.Subsidy;

import persistence.HandlerLanguage;
import persistence.TextFieldManager;
import utilities.Utilities;
import views.Constant;
import views.JMainPayRoll;

import static javax.swing.JOptionPane.*;

public class Controller implements ActionListener{

	private Subsidy subsidy;
	private JMainPayRoll jMainPayRoll;
	public static final String ENGLISH_PATH = "resources/languages/languageUS.properties";
	public static final String SPANISH_PATH = "resources/languages/languageES.properties";
	private static final String NAME_FILE_CONFIG = "resources/config/config.init";

	private HandlerLanguage config;
	private TextFieldManager fieldManager;

	/**
	 *
	 */
	private void manageChangeLanguageUS(){
		try {
			changeToEnglish();
		} catch (IOException e1) {
			showMessageDialog(jMainPayRoll, e1.getMessage());
		}
		manageChangeLanguage();
	}

	public Controller() {
		loadConfiguration();
		fieldManager = new TextFieldManager();
		subsidy = new Subsidy();
		jMainPayRoll = new JMainPayRoll(this);
		startApp();
	}

	private void startApp() {
		try {
			ArrayList<String> datasList = fieldManager.readFile(Constant.PATH_FILE_IN);
			managerTokenListen(datasList);
		} catch (IOException e) {
			showMessageDialog( null, "Archivo no encontrado ", "Failure", ERROR_MESSAGE);
		}
	}

	private void managerTokenListen(ArrayList<String> datasList) {
		for (String data : datasList) {
			String[] auxList = Utilities.splitLine(data);
			if (auxList.length == 7) {
				Register register = subsidy.createRegister(auxList[0],Utilities.geTypeOfPerson(auxList[1]), Utilities.geTypeOfDocument(auxList[2]),
						Utilities.geTypeOfSolicitude(auxList[3]),auxList[4],Integer.parseInt(auxList[5]),Utilities.getDates(auxList[6]));
				subsidy.addRegister(register);
				subsidy.generateCode();
			}
		}

	}

	private void writeDatas() {
		ArrayList<String> auxDatas = Utilities.getDataForWrite(subsidy.getMatrixData());
		fieldManager.writeFile(Constant.PATH_FILE_OUT, auxDatas);
	}
	private void loadConfiguration() {
		if(config == null){
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try{
			config.loadLanguage();
		}catch(IOException e){
			showMessageDialog(jMainPayRoll, e.getMessage());
		}
	}

	private void manageChangeLanguageES(){
		try {
			changeToSpanish();
		} catch (IOException e1) {
			showMessageDialog(jMainPayRoll, e1.getMessage());
		}	
		manageChangeLanguage();
	}

	private void manageChangeLanguage(){
		jMainPayRoll.changeLanguage();		
	}
	
	public void loadLanguage(){
		try {
			config.loadLanguage();
		} catch (IOException e) {
			showMessageDialog(jMainPayRoll, e.getMessage());
		}
	}

	public void saveConfig(){
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (IOException e) {
			showMessageDialog(jMainPayRoll, e.getMessage());
		}
	}

	public void changeToEnglish() throws IOException{
		HandlerLanguage.language = ENGLISH_PATH;
		saveConfig();
		loadLanguage();		
	}
	
	public void changeToSpanish() throws IOException{
		HandlerLanguage.language = SPANISH_PATH;
		saveConfig();
		loadLanguage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Command.valueOf(e.getActionCommand())) {
		case C_WRITE_DATA: this.writeDatas();
		case C_ES_LANGUAGE: this.manageChangeLanguageES(); break;
		case C_US_LANGUAGE: this.manageChangeLanguageUS(); break;
		case C_CREATE_NEW_PAYROLL: this.createPayroll(); break;
		case C_SHOW_NEW_PAYROLL: this.showDialog(); break;
		case C_REFRESH_DATA: this.managerRefreshData(); break;
		case C_CANCEL_CREATE_PAYROLL: jMainPayRoll.makeInvisibleDialogAddCost(); break;
		case C_SEARCH_PAYROLL: this.managerSearchData(); break;
		case C_DELETE_PAYROLL: this.deleteManagerData(); break;
		case C_EXIT_APP: this.exitApp(); break;
		case C_SHOW_PERCENTAGE_PERSON_TABLE: this.showPorcentageDatas(0); break;
		case C_SHOW_PERCENTAGE_DOCU_TABLE: this.showPorcentageDatas(1); break;
		case C_SHOW_PERCENTAGE_SOLI_TABLE: this.showPorcentageDatas(2); break;
		case C_SHOW_PERCENTAGE_DATES_TABLE: this.showPorcentageDatas(3); break;
		case C_SHOW_PERCENTAGE_PERSON_BAR: this.showPorcentageDatas(4); break;
		case C_SHOW_PERCENTAGE_DOCU_BAR: this.showPorcentageDatas(5); break;
		case C_SHOW_PERCENTAGE_SOLI_BAR: this.showPorcentageDatas(6); break;
		case C_SHOW_PERCENTAGE_DATES_BAR: this.showPorcentageDatas(7); break;
		default:
			break;
		}
	}

	private void showPorcentageDatas(int value) {
		switch (value) {
		case 0:
			jMainPayRoll.showPercentageDatas(subsidy.getPercentagesOfTypePerAll(),Constant.HEADERS_TYPE_PERSON);
			break;
		case 1:
			jMainPayRoll.showPercentageDatas(subsidy.getPercentagesOfTypeDocuAll(),Constant.HEADERS_TYPE_DOCUMENT);
			break;
		case 2:
			jMainPayRoll.showPercentageDatas(subsidy.getPercentagesOfTypeSoliAll(),Constant.HEADERS_TYPE_SOLICITUDE);
			break;
		case 3:
			jMainPayRoll.showPercentageDatas(subsidy.getPercentageOnDateAll(),Constant.HEADERS_TYPE_DATE);
			break;
		case 4:
			jMainPayRoll.showPercentageDataBar(subsidy.getPercentagesOfTypePerAll(), Constant.HEADERS_TYPE_PERSON,Constant.HEADERS_TYPE_PERCENTAGE[0]);
			break;
			case 5:
			jMainPayRoll.showPercentageDataBar(subsidy.getPercentagesOfTypeDocuAll(), Constant.HEADERS_TYPE_DOCUMENT,Constant.HEADERS_TYPE_PERCENTAGE[1]);
			break;
			case 6:
				jMainPayRoll.showPercentageDataBar(subsidy.getPercentagesOfTypeSoliAll(), Constant.HEADERS_TYPE_SOLICITUDE,Constant.HEADERS_TYPE_PERCENTAGE[2]);
				break;
			case 7:
			jMainPayRoll.showPercentageDataBar(subsidy.getPercentageOnDateAll(), Constant.HEADERS_TYPE_DATE,Constant.HEADERS_TYPE_PERCENTAGE[3]);
			break;
			default:
			break;
		}
	}
	
	private void managerSearchData() {
		// TODO Auto-generated method stub
		
	}
	
	private void deleteManagerData() {
		String select = jMainPayRoll.getSelectedRow();
		if (select.equals(Constant.ERROR_SELECT)) {
			showMessageDialog(jMainPayRoll, Constant.NOT_SELECT_ITEM);
			managerRefreshData();
		}else {
			int option = showConfirmDialog(jMainPayRoll,Constant.DELETE_SELECT_ITEM);
			if (option == YES_OPTION) {
				jMainPayRoll.deletePayroll(jMainPayRoll.getSelectRow());
				subsidy.deleteRegister(select);
			}
		}
	}

	private void managerRefreshData() {
		jMainPayRoll.addElementToTable(subsidy.getMatrixData());
		jMainPayRoll.updatePayroll(subsidy.getBonus());
	}

	private void showDialog() {
		jMainPayRoll.showDialogCreatePayroll();
	}

	private void createPayroll() {
		Register auxRegister = jMainPayRoll.createRegister(subsidy);
		if (auxRegister != null) {
			subsidy.addRegister(auxRegister);
			subsidy.generateCode();
			jMainPayRoll.addElementToTable(auxRegister.toVectorObject());
			double bonus = subsidy.getBonus();
			jMainPayRoll.updatePayroll(bonus);
		}else {
			showMessageDialog(null, "Hay datos Vacios por favor llenarlos todos");
			showDialog();
		}
	}

	private void exitApp() {
		int option = showConfirmDialog(null, "Deseas salir");
		if (option == 0) {
			System.exit(0);
		}
	}	
}
