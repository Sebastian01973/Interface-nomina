package views.model;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import views.Constant;

public class JModelDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JModelDialog(String title,String imagePath,int width,int height) {
		setModal(true);
		setTitle(title);
		setIconImage( new ImageIcon(getClass().getResource(imagePath)).getImage());
		setSize(new Dimension(width,height));
		getContentPane().setBackground(Constant.COLOR_WHITE);
	}
	
}
