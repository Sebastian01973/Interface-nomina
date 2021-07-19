package views.header;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import views.Constant;
import views.model.JModelButton;
import views.model.JModelLabel;

public class JPWestHeaderPanel extends JPanel{
	
	JModelLabel jModelLabel;
	JModelButton buttonBack,buttonNext;
	
	public JPWestHeaderPanel(ActionListener actionListener) {
		this.setLayout(new FlowLayout(0));
		this.setBackground(Constant.COLOR_WHITE);
		this.setOpaque(true);
		initComponents(actionListener);
	}

	private void initComponents(ActionListener actionListener) {
		
		buttonBack = new JModelButton("Back", Constant.IMG_BUTTON_BACK,Constant.FONT_NEW_ROMAN_13,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
		this.add(buttonBack);
		buttonNext = new JModelButton("Next", Constant.IMG_BUTTON_NEXT,Constant.FONT_NEW_ROMAN_13,Constant.COLOR_WHITE,Constant.COLOR_BLACK);
		this.add(buttonNext);
		ImageIcon imagen = new ImageIcon(getClass().getResource(Constant.IMG_LOGO_MAIN));
		Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH));
		jModelLabel = new JModelLabel(icon);
		this.add(jModelLabel);
	}

	public static void changeLanguage() {
		// TODO Auto-generated method stub
		
	}
}
