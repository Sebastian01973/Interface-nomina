package views.model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class JModelProgressBar extends JProgressBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ActionListener actionListener;
	
	public JModelProgressBar(int value,int width,int height,Color bg) {
		this.setStringPainted(true);
		this.setValue(value);
		this.setSize(new Dimension(width, height));
		this.setBackground(bg);
	}
	
	public void editProgressBar(JModelProgressBar bar) {
		this.setUI(new BasicProgressBarUI() {
			@Override
			protected void paintDeterminate(Graphics g, JComponent c) {
				Graphics2D g2 = (Graphics2D) g;
				int width = bar.getWidth();
			}
		});
	}
	
	int x = 0;
	Timer timer;
	public void actionP(JModelProgressBar progressBar) {
		actionListener = new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				x = x+1;
				progressBar.setValue(x);
			}
		};
		timer = new Timer(20, actionListener);
		timer.start();
	}
}
