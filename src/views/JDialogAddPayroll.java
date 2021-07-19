package views;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatter;

import com.toedter.calendar.JDateChooser;
import com.uptc.prg2.model.Register;
import com.uptc.prg2.model.Subsidy;
import com.uptc.prg2.model.TypeOfDocument;
import com.uptc.prg2.model.TypeOfPerson;
import com.uptc.prg2.model.TypeOfSolicitude;

import controllers.Command;
import utilities.Utilities;
import utilities.UtilitiesViews;
import views.model.JModelButton;
import views.model.JModelComboBox;
import views.model.JModelTextField;

public class JDialogAddPayroll extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpContainer;
	private JModelComboBox jCPTypeOfPers,jCBSolicitude,jCBTypeOfDocu;
	private JSpinner jsValue;
	private JDateChooser jdCalendar;
	private JModelTextField jTFName,jTFNit;
	private JModelButton jBCreate,jBCancel;
	
	public JDialogAddPayroll(ActionListener actionListener,JMainPayRoll jMainPayRoll) {
		setModal(true);
		setTitle(Utilities.getConstant(Constant.NEW_SUBSIDY));
		setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_JDIALOG_NEW_PAYROLL)).getImage());
		setSize(new Dimension(500, 650));
		getContentPane().setBackground(Constant.COLOR_WHITE);
		setLocationRelativeTo(jMainPayRoll);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jpContainer = new JPanel();
		jpContainer.setBackground(Constant.COLOR_WHITE);
		GridLayout grid = new GridLayout(9,1);
		jpContainer.setBorder( new EmptyBorder( 25, 25, 0, 25));
		grid.setVgap(15);jTFName = new JModelTextField(Utilities.getConstant(Constant.NAME_OF_COMPANY),Constant.ENTER_NAME,Constant.FONT_ARIAL_ROUNDER_15,Constant.COLOR_WHITE);
		jTFName.validateText(jTFName);
		jpContainer.add( jTFName );
		jpContainer.setLayout(grid);

		
		jCPTypeOfPers = new JModelComboBox(Utilities.getConstants(TypeOfPerson.values()),Utilities.getConstant(Constant.TYPE_OF_PERSON), Constant.FONT_COMPONENTS_DIALOG_COST);
		jpContainer.add(jCPTypeOfPers);
		
		jCBTypeOfDocu = new JModelComboBox(Utilities.getConstants(TypeOfDocument.values()),Utilities.getConstant(Constant.TYPE_OF_DOCU),Constant.FONT_COMPONENTS_DIALOG_COST);
		jpContainer.add(jCBTypeOfDocu);
		
		jCBSolicitude = new JModelComboBox(Utilities.getConstants(TypeOfSolicitude.values()),Utilities.getConstant(Constant.TYPE_OF_SOLI),Constant.FONT_COMPONENTS_DIALOG_COST);
		jpContainer.add(jCBSolicitude);
		
		jTFNit = new JModelTextField(Utilities.getConstant(Constant.NIT_OF_COMPANY),Constant.ENTER_NIT,Constant.FONT_ARIAL_ROUNDER_15,Constant.COLOR_WHITE);
		jTFNit.validateNum(jTFNit);
		jpContainer.add( jTFNit );

		jsValue = new JSpinner(new SpinnerNumberModel(3, 0, Integer.MAX_VALUE, 1));
		((DefaultFormatter) ((JSpinner.NumberEditor)jsValue.getEditor()).getTextField().getFormatter()).setAllowsInvalid(false);
		jsValue.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.NUMBER_EMPLEOYEES)));
		jsValue.setBackground(Constant.COLOR_WHITE);
		jpContainer.add(jsValue);
		jdCalendar = new JDateChooser();
		jpContainer.add(jdCalendar);

		jBCreate = new JModelButton(15, 15,Utilities.getConstant(Constant.CREATE), Constant.COLOR_BLUE_LIGHT, Constant.COLOR_WHITE, 
		Constant.FONT_COMPONENTS_DIALOG_COST, Command.C_CREATE_NEW_PAYROLL.toString(), actionListener );
		jpContainer.add(jBCreate);
		jBCancel = new JModelButton( 15, 15,Utilities.getConstant( Constant.CANCEL), Constant.COLOR_RED_LIGHT, Constant.COLOR_WHITE, 
		Constant.FONT_COMPONENTS_DIALOG_COST, Command.C_CANCEL_CREATE_PAYROLL.toString(), actionListener );
		jpContainer.add( jBCancel );
		this.add( jpContainer );
	}
	

	public void showDialog() {
		jTFName.setText("");
		jTFNit.setText("");
		jdCalendar.setDate(null);
	}

	public Register createRegister(Subsidy subsidy, JMainPayRoll jMainPayRoll) {
		if (!Utilities.isValidateDatas(jTFName.getText(), jTFNit.getText(), jdCalendar.getDate())) {
			setVisible(false);
			System.out.println(jCPTypeOfPers.getSelectedIndex());
			System.out.println(jCPTypeOfPers.getSelectedItem());
			return subsidy.createRegister(jTFName.getText(),Utilities.getTypeOfPerson(jCPTypeOfPers.getSelectedIndex()),
					Utilities.getTypeOfDocument(jCBTypeOfDocu.getSelectedIndex()),Utilities.getTypeOfSolicitude(jCBSolicitude.getSelectedIndex()),
					jTFNit.getText(),(int) jsValue.getValue(),UtilitiesViews.parseDateToLocalDate(jdCalendar.getDate()));
			
		}else {
			return null;
		}
	}
	
	
	public void changeLanguage() {
		this.setTitle(Utilities.getConstant(Constant.NEW_SUBSIDY));
		jTFName.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.NAME_OF_COMPANY)));
		jCPTypeOfPers.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.TYPE_OF_PERSON)));
		jCBTypeOfDocu.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.TYPE_OF_DOCU)));
		jCBSolicitude.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.TYPE_OF_SOLI)));
		jTFNit.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.NIT_OF_COMPANY)));
		jsValue.setBorder(BorderFactory.createTitledBorder(Utilities.getConstant(Constant.NUMBER_EMPLEOYEES)));
		jBCreate.setText(Utilities.getConstant(Constant.CREATE));
		jBCancel.setText(Utilities.getConstant(Constant.CANCEL));
		jCBTypeOfDocu.setItems(Utilities.getConstants(TypeOfDocument.values()));
		jCBSolicitude.setItems(Utilities.getConstants(TypeOfSolicitude.values()));
		jCPTypeOfPers.setItems(Utilities.getConstants(TypeOfPerson.values()));
	}
}