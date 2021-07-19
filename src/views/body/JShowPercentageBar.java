package views.body;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utilities.Utilities;
import views.Constant;
import views.model.JModelButton;
import views.model.JModelLabel;
import views.model.JModelProgressBar;
import views.model.JModelTextField;

public class JShowPercentageBar extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JModelLabel label;
	JPanel jPanel;
	JModelButton delete,cancel;
	JModelTextField textField;

	public JShowPercentageBar() {
		setModal(true);
		setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_STADISTIC)).getImage());
		getContentPane().setBackground(Constant.COLOR_WHITE);
		this.setSize(new Dimension(500, 500));
		initComponents();
	}
	
	private void initComponents() {
		jPanel = new JPanel();
		jPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		BoxLayout box = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
		jPanel.setLayout(box);
		jPanel.setBackground(Constant.COLOR_OF_DIALOG_PERC);
		
	}
	
	public void resetDatas(Object[] objects, String[] headers,String title) {
		this.setTitle(Utilities.getConstant(title));
		for (int i = 0; i < objects.length; i++) {
			double floatAux = (float) objects[i];
			label = new JModelLabel(Utilities.getConstant(headers[i]),Constant.COLOR_WHITE,Constant.FONT_ARIAL_ROUNDER_15);
			JModelProgressBar jBar = new JModelProgressBar((int)floatAux, 300, 40,Constant.COLOR_LIGHT_BLUE);
			jPanel.add(label);
			jPanel.add(jBar);
		}
		this.add(jPanel);
	}
}
