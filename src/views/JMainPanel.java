package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import views.body.JTableElements;
import views.footer.JContainerFooter;
import views.header.JContainerHeader;

public class JMainPanel extends JPanel{
	
	public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	private JContainerHeader jContainerHeader;
	private JTableElements jContainerBody;
	private JContainerFooter jContainerFooter;

	public JMainPanel(ActionListener actionListener) {
		this.setLayout(new BorderLayout(0, 0));
		this.setBackground(Constant.COLOR_WHITE);
		initComponents( actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jContainerHeader = new JContainerHeader(actionListener);
		this.add(jContainerHeader,BorderLayout.NORTH);
		
		jContainerBody = new JTableElements();
		this.add(jContainerBody,BorderLayout.CENTER);
		
		jContainerFooter = new JContainerFooter(actionListener);
		this.add(jContainerFooter,BorderLayout.SOUTH);
		
	}
	
	public void addElementToTable(Object[] objects) {
		jContainerBody.addElementToTable(objects);
	}
	
	public void addElementToTable(ArrayList<Object[]> data) {
		jContainerBody.addElementToTable(data);
	}

	public void updatePayRoll(double bonus) {
		jContainerBody.updatePayRoll(bonus);
	}

	public void showPercentageDatas(Object[] objects,String[] headers) {
		jContainerBody.showPercentageDatas(objects,headers);
	}
	
	public String getSelectedRow() {
		return jContainerBody.getSelectedRow();
	}
	
	public int getSelectRow() {
		return jContainerBody.getSelectRow();
	}

	public void deletePayroll(int index) {
		jContainerBody.deletePayroll(index);
	}

	public void changeLanguage() {
		jContainerHeader.changeLanguage();
		jContainerBody.changeLanguage();
		jContainerFooter.changeLanguage();
	}

}
