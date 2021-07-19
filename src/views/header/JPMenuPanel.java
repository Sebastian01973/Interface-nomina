package views.header;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import controllers.Command;
import utilities.Utilities;
import views.Constant;
import views.model.JModelMenu;
import views.model.JModelMenuItem;

public class JPMenuPanel extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JModelMenu menuStadistic,menuFile,menuLanguage;
	private JModelMenuItem jMNewPayroll,jMsearchPayroll,jMdeletePayroll,jMExitApp,jMLSpanish,jMLEnglish;
	private JModelMenuItem jMShowList,jMShowPercOfDateTable,jMShowPercOfPersonTable,jMShowPercOfSoliTable,jMShowPercOfDocuTable;
	private JModelMenuItem jMShowPercOfDateBar,jMShowPercOfPersonBar,jMShowPercOfSoliBar,jMShowPercOfDocuBar;
	private JModelMenu menuShowPerOfDate,menuShowPerOfPerson,menuShowPerOfDocument,menuShowPerOfSolicitude;

	public JPMenuPanel(ActionListener actionListener) {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Constant.COLOR_DARK_BLUE);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		showMenuMain(actionListener);
		showMenuStadistic(actionListener);
		showMenuLanguage(actionListener);
	}
	
	private void showMenuLanguage(ActionListener actionListener) {
		menuLanguage = new JModelMenu(Utilities.getConstant(Constant.M_LANGUAGE),Constant.COLOR_LIGHT_BLUE,Constant.COLOR_WHITE,Constant.FONT_NEW_ROMAN_25);
		
		jMLSpanish = new JModelMenuItem(Utilities.getConstant(Constant.M_SPANISH), Constant.IMG_SPANISH,Constant.FONT_ROCWELL,15,15);
		jMLSpanish.setActionCommand(Command.C_ES_LANGUAGE.toString().toString());
		jMLSpanish.addActionListener(actionListener);
		menuLanguage.add(jMLSpanish);
		
		jMLEnglish = new JModelMenuItem(Utilities.getConstant(Constant.M_ENGLISH), Constant.IMG_ENGLISH,Constant.FONT_ROCWELL,15,15);
		jMLEnglish.setActionCommand(Command.C_US_LANGUAGE.toString().toString());
		jMLEnglish.addActionListener(actionListener);
		menuLanguage.add(jMLEnglish);
		
		this.add(menuLanguage);
		
	}

	private void showMenuMain(ActionListener actionListener) {
		menuFile = new JModelMenu(Utilities.getConstant(Constant.M_FILE),Constant.COLOR_LIGHT_BLUE,Constant.COLOR_WHITE,Constant.FONT_NEW_ROMAN_25);
		
		jMNewPayroll = new JModelMenuItem(Utilities.getConstant(Constant.M_ADD),Constant.IMG_ADD,Constant.FONT_ROCWELL);
		jMNewPayroll.setActionCommand(Command.C_SHOW_NEW_PAYROLL.toString());
		jMNewPayroll.addActionListener(actionListener);
		jMNewPayroll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_DOWN_MASK));
		menuFile.add(jMNewPayroll);
		
		jMsearchPayroll = new JModelMenuItem(Utilities.getConstant(Constant.M_SEARCH), Constant.IMG_SEARCH,Constant.FONT_ROCWELL);
		jMsearchPayroll.setActionCommand(Command.C_SEARCH_PAYROLL.toString());
		jMsearchPayroll.addActionListener(actionListener);
		jMsearchPayroll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,InputEvent.CTRL_DOWN_MASK));
		menuFile.add(jMsearchPayroll);
		
		jMdeletePayroll = new JModelMenuItem(Utilities.getConstant(Constant.M_DELETE),Constant.IMG_DELETE,Constant.FONT_ROCWELL);
		jMdeletePayroll.setActionCommand(Command.C_DELETE_PAYROLL.toString());
		jMdeletePayroll.addActionListener(actionListener);
		jMdeletePayroll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_DOWN_MASK));
		menuFile.add(jMdeletePayroll);
		
		jMExitApp = new JModelMenuItem(Utilities.getConstant(Constant.M_EXIT), Constant.IMG_EXIT, Constant.FONT_ROCWELL);
		jMExitApp.setActionCommand(Command.C_EXIT_APP.toString());
		jMExitApp.addActionListener(actionListener);
		jMExitApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10,InputEvent.CTRL_DOWN_MASK));
		jMExitApp.setBackground(Constant.COLOR_LIGHT_BLUE);
		menuFile.add(jMExitApp);
		menuFile.addSeparator();
		this.add(menuFile);
	}
	
	private void showMenuStadistic(ActionListener actionListener) {
		menuStadistic = new JModelMenu(Utilities.getConstant(Constant.M_STADISTIC), Constant.COLOR_LIGHT_BLUE,Constant.COLOR_WHITE,Constant.FONT_NEW_ROMAN_25);
		
		jMShowList = new JModelMenuItem(Utilities.getConstant(Constant.M_LIST_REGISTER),Constant.FONT_ROCWELL,Constant.COLOR_WHITE);
		jMShowList.setActionCommand(Command.C_REFRESH_DATA.toString());
		jMShowList.addActionListener(actionListener);
		jMShowList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.ALT_DOWN_MASK));
		menuStadistic.add(jMShowList);
		
		menuShowPerOfPerson = new JModelMenu(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_PERSON), Constant.COLOR_WHITE, Constant.FONT_ROCWELL);
		
		jMShowPercOfPersonTable = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfPersonTable.setActionCommand(Command.C_SHOW_PERCENTAGE_PERSON_TABLE.toString());
		jMShowPercOfPersonTable.addActionListener(actionListener);
		jMShowPercOfPersonTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.ALT_DOWN_MASK));
		menuShowPerOfPerson.add(jMShowPercOfPersonTable);
		
		jMShowPercOfPersonBar = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_BAR),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfPersonBar.setActionCommand(Command.C_SHOW_PERCENTAGE_PERSON_BAR.toString());
		jMShowPercOfPersonBar.addActionListener(actionListener);
		menuShowPerOfPerson.add(jMShowPercOfPersonBar);
		
		menuStadistic.add(menuShowPerOfPerson);
		
		menuShowPerOfDocument = new JModelMenu(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_DOCUMENT), Constant.COLOR_WHITE, Constant.FONT_ROCWELL);
		
		jMShowPercOfDocuTable = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfDocuTable.setActionCommand(Command.C_SHOW_PERCENTAGE_DOCU_TABLE.toString());
		jMShowPercOfDocuTable.addActionListener(actionListener);
		jMShowPercOfDocuTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.ALT_DOWN_MASK));
		menuShowPerOfDocument.add(jMShowPercOfDocuTable);
		
		jMShowPercOfDocuBar = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_BAR),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfDocuBar.setActionCommand(Command.C_SHOW_PERCENTAGE_DOCU_BAR.toString());
		jMShowPercOfDocuBar.addActionListener(actionListener);
		menuShowPerOfDocument.add(jMShowPercOfDocuBar);
		
		menuStadistic.add(menuShowPerOfDocument);
		
		menuShowPerOfSolicitude = new JModelMenu(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_SOLICITU), Constant.COLOR_WHITE, Constant.FONT_ROCWELL);
		
		jMShowPercOfSoliTable = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfSoliTable.setActionCommand(Command.C_SHOW_PERCENTAGE_SOLI_TABLE.toString());
		jMShowPercOfSoliTable.addActionListener(actionListener);
		jMShowPercOfSoliTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.ALT_DOWN_MASK));
		menuShowPerOfSolicitude .add(jMShowPercOfSoliTable);
		
		jMShowPercOfSoliBar = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_BAR),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfSoliBar.setActionCommand(Command.C_SHOW_PERCENTAGE_SOLI_BAR.toString());
		jMShowPercOfSoliBar.addActionListener(actionListener);
		menuShowPerOfSolicitude.add(jMShowPercOfSoliBar);
		
		menuStadistic.add(menuShowPerOfSolicitude);
		
		menuShowPerOfDate = new JModelMenu(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_DATE), Constant.COLOR_WHITE, Constant.FONT_ROCWELL);
		
		jMShowPercOfDateTable = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfDateTable.setActionCommand(Command.C_SHOW_PERCENTAGE_DATES_TABLE.toString());
		jMShowPercOfDateTable.addActionListener(actionListener);
		jMShowPercOfDateTable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.ALT_DOWN_MASK));
		menuShowPerOfDate.add(jMShowPercOfDateTable);
		
		jMShowPercOfDateBar = new JModelMenuItem(Utilities.getConstant(Constant.M_PERCENTAGE_BAR),Constant.FONT_ROCWELL, Constant.COLOR_WHITE);
		jMShowPercOfDateBar.setActionCommand(Command.C_SHOW_PERCENTAGE_DATES_BAR.toString());
		jMShowPercOfDateBar.addActionListener(actionListener);
		menuShowPerOfDate.add(jMShowPercOfDateBar);
		
		menuStadistic.add(menuShowPerOfDate);
		
		menuStadistic.addSeparator();
		this.add(menuStadistic);
	}
	
	public void changeLanguage() {
		menuLanguage.setText(Utilities.getConstant(Constant.M_LANGUAGE));
		jMLSpanish.setText(Utilities.getConstant(Constant.M_SPANISH));
		jMLEnglish.setText(Utilities.getConstant(Constant.M_ENGLISH));
		
		menuFile.setText(Utilities.getConstant(Constant.M_FILE));
		jMNewPayroll.setText(Utilities.getConstant(Constant.M_ADD));
		jMsearchPayroll.setText(Utilities.getConstant(Constant.M_SEARCH));
		jMdeletePayroll.setText(Utilities.getConstant(Constant.M_DELETE));
		jMExitApp.setText(Utilities.getConstant(Constant.M_EXIT));
		
		menuStadistic.setText(Utilities.getConstant(Constant.M_STADISTIC));
		jMShowList.setText(Utilities.getConstant(Constant.M_LIST_REGISTER));
		menuShowPerOfPerson.setText(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_PERSON));
		jMShowPercOfPersonTable.setText(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE));
		jMShowPercOfPersonBar.setText(Utilities.getConstant(Constant.M_PERCENTAGE_BAR));
		
		menuShowPerOfDocument.setText(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_DOCUMENT));
		jMShowPercOfDocuTable.setText(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE));
		jMShowPercOfDocuBar.setText(Utilities.getConstant(Constant.M_PERCENTAGE_BAR));
		
		menuShowPerOfSolicitude.setText(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_SOLICITU));
		jMShowPercOfSoliTable.setText(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE));
		jMShowPercOfSoliBar.setText(Utilities.getConstant(Constant.M_PERCENTAGE_BAR));
		
		menuShowPerOfDate.setText(Utilities.getConstant(Constant.M_LIST_PERCENTAGE_DATE));
		jMShowPercOfDateTable.setText(Utilities.getConstant(Constant.M_PERCENTAGE_TABLE));
		jMShowPercOfDateBar.setText(Utilities.getConstant(Constant.M_PERCENTAGE_BAR));
	}
}
