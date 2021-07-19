package views.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class JModelButtonLinks extends JButton{
	
	private String link;
	private boolean status;

	public JModelButtonLinks(String text,String imagePath,Font font, Color...colors) {
		super(text);
		this.setFont( font );
		this.setIcon( new ImageIcon(getClass().getResource( imagePath )) );
		this.setBorderPainted( false );
		this.setFocusable( false );
		this.setOpaque(false);
		this.setHorizontalTextPosition( SwingConstants.CENTER );
		this.setVerticalTextPosition( SwingConstants.BOTTOM );
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBackground(colors[0]);
		this.setForeground(colors[1]);
		
		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				openLink();
			}
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				status = true;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				status = false;
				repaint();
			}
				
		});
	}
	
	private void openLink() {
		try {
			Desktop.getDesktop().browse(new URI(link));
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (status) {
			g2.rotate(Math.toRadians(30),getWidth()/2,getHeight()/2);
		}
		super.paint(g2);
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
}
