package views.model;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JModelLabel extends JLabel{

	/**
	 * @descprtion Este metodo nos agrega una imagen a un label
	 * @param icon
	 */
	public JModelLabel(String imagePath) {
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )));
	}

	public JModelLabel(String imagePath,int width,int height) {



	}
	
	public JModelLabel(String text,Color fg,Font font) {
		super(text);
		this.setOpaque(false);
		this.setFont(font);
		this.setForeground(fg);
	}
	
	public JModelLabel(Icon icon) {
		super(icon);
		this.setOpaque(false);
	}
}
