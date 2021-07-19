package views.header;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controllers.Command;
import views.Constant;
import views.model.JModelButton;

public class JMainToolBar extends JToolBar{

	private JModelButton jbadd,jbsearch,jbdelete,jbRefresh,exitButton,jbwrite;
	
	public JMainToolBar(ActionListener actionListener) {
		setIUManager();
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Constant.COLOR_LIGHT_GREEN);
		setFloatable(false);
		initComponents(actionListener);
	}
	
	private void initComponents(ActionListener actionListener) {
		jbadd = new JModelButton(Constant.IMG_ADD_USER,25,25);
		jbadd.setToolTipText("Agregar");
		jbadd.setActionCommand(Command.C_SHOW_NEW_PAYROLL.toString());
		jbadd.addActionListener(actionListener);
		this.add(jbadd);
		
		jbsearch = new JModelButton(Constant.IMG_SEARCH_USER,25,25);
		this.add(jbsearch);
		
		jbdelete = new JModelButton(Constant.IMG_DELETE_USER,25,25);
		jbdelete.setBackground(Constant.COLOR_WHITE);
		jbdelete.setActionCommand(Command.C_DELETE_PAYROLL.toString());
		jbdelete.addActionListener(actionListener);
		this.add(jbdelete);
		
		jbRefresh = new JModelButton(Constant.IMG_REFRESH, 25, 25);
		jbRefresh.setActionCommand(Command.C_REFRESH_DATA.toString());
		jbRefresh.addActionListener(actionListener);
		this.add(jbRefresh);
		
		jbwrite = new JModelButton(Constant.IMG_WRITE, 25,25);
		jbwrite.setActionCommand(Command.C_WRITE_DATA.toString());
		jbwrite.addActionListener(actionListener);
		this.add(jbwrite);
		
		exitButton = new JModelButton(Constant.IMG_EXIT_USER,25,25);
		exitButton.setActionCommand(Command.C_EXIT_APP.toString());
		exitButton.addActionListener(actionListener);
		this.add(exitButton);
	}

	public void setIUManager() {
		UIManager.put("Button.background", Constant.COLOR_WHITE);
	}
	
}
