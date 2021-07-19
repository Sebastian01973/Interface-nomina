package views.header;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class JContainerHeader extends JPanel{
	
	private JPWestHeaderPanel jpNorthPanel;
	private JPMenuPanel jpMenuPanel;
	private JMainToolBar jMainToolBar;
	private JPFlatSocial jpFlatSocial;

	public JContainerHeader(ActionListener actionListener) {
		this.setLayout(new BorderLayout(0,0));
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		jpNorthPanel = new JPWestHeaderPanel(actionListener);
		this.add(jpNorthPanel,BorderLayout.WEST);
		
		jpMenuPanel = new JPMenuPanel(actionListener);
		this.add(jpMenuPanel,BorderLayout.CENTER);
		
		jpFlatSocial = new JPFlatSocial(actionListener);
		this.add(jpFlatSocial,BorderLayout.EAST);
		
		jMainToolBar = new JMainToolBar(actionListener);
		this.add(jMainToolBar,BorderLayout.SOUTH);
	}

	public void changeLanguage() {
		jpMenuPanel.changeLanguage();
		JPWestHeaderPanel.changeLanguage();
	}
}
