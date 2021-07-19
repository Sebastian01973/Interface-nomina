package views.header;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import views.Constant;
import views.model.JModelButtonLinks;


/**
 * @description Esta clase nos muestra las redes sociales del creador
 * @author Sebastian Martinez
 * @date 20/06/2020
 */
public class JPFlatSocial extends JPanel{

	//Mis redes sociales xd
	private JModelButtonLinks twitter,instagram,facebook;
	/**
	 * @descprtion Este el constructor
	 */
	public JPFlatSocial(ActionListener actionListener) {
		this.setLayout(new FlowLayout(0));
		this.setBackground(Constant.COLOR_DARK_BLUE);
		initComponents(actionListener);
	}

	/**
	 * @description Este metodo nos inicializa los botones
	 */
	private void initComponents(ActionListener actionListener) {
		facebook = new JModelButtonLinks(Constant.TXT_FACEBOOK,Constant.IMG_LOGO_FACEBOOK,Constant.FONT_NEW_ROMAN_13, Constant.COLOR_DARK_BLUE,Constant.COLOR_WHITE);
		facebook.setLink("https://www.facebook.com/sebastian.shamak/");
		this.add(facebook);
		
		instagram = new JModelButtonLinks(Constant.TXT_INSTAGRAM,Constant.IMG_LOGO_INSTAGRAM,Constant.FONT_NEW_ROMAN_13, Constant.COLOR_DARK_BLUE,Constant.COLOR_WHITE);
		instagram.setLink("");
		this.add(instagram);
		
		twitter = new JModelButtonLinks(Constant.TXT_TWITTER,Constant.IMG_LOGO_TWITTER,Constant.FONT_NEW_ROMAN_13, Constant.COLOR_DARK_BLUE,Constant.COLOR_WHITE);
		this.add(twitter);
	}
}
