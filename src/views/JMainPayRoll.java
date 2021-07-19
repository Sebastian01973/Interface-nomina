package views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.sun.net.httpserver.Headers;
import com.uptc.prg2.model.Register;
import com.uptc.prg2.model.Subsidy;

import persistence.HandlerLanguage;
import views.body.JShowPercentageBar;
import views.model.JModelDialog;
import views.model.JModelLabel;

public class JMainPayRoll extends JFrame{

	JDialogAddPayroll jDialogAddPayroll;
	JMainPanel jMainPanel;
	JShowPercentageBar jcontainerDialog;
	JModelDialog dialogDelete,dialogSearch;
	
	public JMainPayRoll( ActionListener actionListener) {
		this.setTitle( HandlerLanguage.languageProperties.getProperty(Constant.TITLE_PAYROLL));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon(getClass().getResource(Constant.IMG_ICON_MAIN)).getImage());
		this.jDialogAddPayroll = new JDialogAddPayroll(actionListener, this);
		initComponents(actionListener);
		this.setVisible(true);
	}
	
	public void initComponents(ActionListener actionListener) {
		jMainPanel = new JMainPanel(actionListener);
		JScrollPane jspPanel = new JScrollPane(jMainPanel);
		this.setExtendedState(MAXIMIZED_BOTH);
		jspPanel.setViewportView(jMainPanel);
		jspPanel.setOpaque(false);
		this.getContentPane().add(jspPanel,BorderLayout.CENTER);
		this.getContentPane().setForeground(Constant.COLOR_WHITE);
		this.setVisible(true);
	}
	
	
	public Register createRegister(Subsidy subsidy) {
		return jDialogAddPayroll.createRegister(subsidy,this);
	}
	
	public void showDialogCreatePayroll() {
		jDialogAddPayroll.setVisible(true);
		jDialogAddPayroll.showDialog();
	}
	
	public void addElementToTable(Object[] objects) {
		jMainPanel.addElementToTable(objects);
	}
	
	public void showPercentageDatas(Object[] objects,String[] headers) {
		jMainPanel.showPercentageDatas(objects,headers);
	}
	
	public void addElementToTable(ArrayList<Object[]> data) {
		jMainPanel.addElementToTable(data);
	}
	
	public void deletePayroll(int index) {
		jMainPanel.deletePayroll(index);
	}
	
	public String getSelectedRow() {
		return jMainPanel.getSelectedRow();
	}
	
	public int getSelectRow() {
		return jMainPanel.getSelectRow();
	}
	
//	public void deletePayroll(Subsidy subsidy) {
//		boolean status = false;
//		String auxString = JOptionPane.showInputDialog("Ingrese el codigo:");
//		int size = subsidy.getSize(); 
//		for (int i = 0; i < size; i++) {
//			if (auxString.equals(subsidy.getCodes()[i])) {
//				subsidy.deleteRegister(auxString);
//				deletePayroll(i);
//				status = true;
//			}
//		}
//		if (!status) {
//			JOptionPane.showMessageDialog(null,"Ese codigo no existe o no es valido");
//			
//		}
//	}

	public void updatePayroll(double bonus) {
		jMainPanel.updatePayRoll(bonus);
	}

	public void makeInvisibleDialogAddCost() {
		jDialogAddPayroll.setVisible(false);
	}

	public void showPercentageDataBar(Object[] objects,String[] headers,String title) {
		jcontainerDialog = new JShowPercentageBar();
		jcontainerDialog.setLocationRelativeTo(this);
		jcontainerDialog.resetDatas(objects, headers, title);
		jcontainerDialog.setVisible(true);
	}

	public void changeLanguage() {
		this.setTitle( HandlerLanguage.languageProperties.getProperty(Constant.TITLE_PAYROLL ));
		jDialogAddPayroll.changeLanguage();
		jMainPanel.changeLanguage();
	}
}
